package com.example.fuelprice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Properties;

public class DBUtility {
    private static String user;
    private static String password;
    private static final String connectURl="jdbc:mysql://sql9.freesqldatabase.com:3306/sql9623932";



    public static void configCredentials() {

        try {

            String configFilePath = "src/main/resources/config.properties";
            FileInputStream propsInput = new FileInputStream(configFilePath);
            Properties prop = new Properties();
            prop.load(propsInput);

            user=prop.getProperty("DB_USER");
            password=prop.getProperty("DB_PASSWORD");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void creatFuelPrice () {

        try (Formatter formatter = new Formatter("creatFuelItem.sql");) {
             formatter.format("INSERT INTO `sql9623932`.`fuelprice`\n" +
                    "(`Date`,`Ottawa`,`Torontowest`,`Torontoeast`,`Winsor`,`London`,`Sudbury`,`Thunderbay`,`Fueltype`)\n" +
                    "VALUES\n" +
                    "(?,?,?,?,?,?,?,?,?);\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
       public static ArrayList<FuelPrice> getFuelPrices() throws SQLException {
            ArrayList<FuelPrice> fuelPrices = new ArrayList<>();
            String sql = "SELECT * FROM sql9623932.fuelprice;";
            try (
                    Connection connection = DriverManager.getConnection(connectURl, user, password);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);

            ) {
                while (resultSet.next()) {
                    Date date = resultSet.getDate("date");
                    Double ottawa = resultSet.getDouble("ottawa");
                    Double torontoWest = resultSet.getDouble("torontoWest");
                    Double torontoEast = resultSet.getDouble("torontoEast");
                    Double winsor = resultSet.getDouble("winsor");
                    Double london = resultSet.getDouble("london");
                    Double sudbury = resultSet.getDouble("sudbury");
                    Double thunderbay = resultSet.getDouble("thunderbay");
                    String fuelType = resultSet.getString("fuelType");
                    FuelPrice fuelPrice = new FuelPrice(date, ottawa, torontoWest, torontoEast, winsor, london,
                            sudbury, thunderbay, fuelType);
                    fuelPrices.add(fuelPrice);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e)
            {
                e.printStackTrace();

            }
            return fuelPrices;

        }
    }

