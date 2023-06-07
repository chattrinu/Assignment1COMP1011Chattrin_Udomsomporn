package com.example.fuelprice;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import static com.example.fuelprice.DBUtility.getFuelPrices;

public class FuelPriceTableViewController implements Initializable {
    @FXML
    private TableColumn<FuelPrice, Date> colDate;

    @FXML
    private TableColumn<FuelPrice, String> colFuelType;

    @FXML
    private TableColumn<FuelPrice, Double> colLondon;

    @FXML
    private TableColumn<FuelPrice, Double> colOttawa;

    @FXML
    private TableColumn<FuelPrice, Double> colSudbury;

    @FXML
    private TableColumn<FuelPrice, Double> colThunderbay;

    @FXML
    private TableColumn<FuelPrice, Double> colTorontoE;

    @FXML
    private TableColumn<FuelPrice, Double> colTorontoW;

    @FXML
    private TableColumn<FuelPrice, Double> colWinsor;

    @FXML
    private TableView<FuelPrice> fuelViewTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       DBUtility.configCredentials();
        try {
            ArrayList<FuelPrice> fuelPrices = getFuelPrices();
            fuelViewTable.getItems().addAll(fuelPrices);
            colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            colOttawa.setCellValueFactory(new PropertyValueFactory<>("ottawa"));
            colTorontoE.setCellValueFactory(new PropertyValueFactory<>("torontoEast"));
            colTorontoW.setCellValueFactory(new PropertyValueFactory<>("torontoWest"));
            colLondon.setCellValueFactory(new PropertyValueFactory<>("london"));
            colWinsor.setCellValueFactory(new PropertyValueFactory<>("winsor"));
            colSudbury.setCellValueFactory(new PropertyValueFactory<>("sudbury"));
            colThunderbay.setCellValueFactory(new PropertyValueFactory<>("thunderbay"));
            colFuelType.setCellValueFactory(new PropertyValueFactory<>("fuelType"));

        } catch (SQLException e) {
         throw new RuntimeException(e);
      }
        System.out.println("successful");

    }
}
