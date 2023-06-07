package com.example.fuelprice;

import java.util.Date;


public class FuelPrice {
    private Date date;
    private Double ottawa;
    private Double torontoWest;
    private Double torontoEast;
    private Double winsor;
    private Double london;
    private Double sudbury;
    private Double thunderbay;
    private String fuelType;

    public FuelPrice(Date date, Double ottawa, Double torontoWest,
                     Double torontoEast, Double winsor, Double london,
                     Double sudbury, Double thunderbay, String fuelType) {
       setDate(date);
       setOttawa(ottawa);
       setTorontoEast(torontoEast);
       setTorontoWest(torontoWest);
       setWinsor(winsor);
       setLondon(london);
       setSudbury(sudbury);
       setThunderbay(thunderbay);
       setFuelType(fuelType);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getOttawa() {
        return ottawa;
    }

    public void setOttawa(Double ottawa) {
        this.ottawa = ottawa;
    }

    public Double getTorontoWest() {
        return torontoWest;
    }

    public void setTorontoWest(Double torontoWest) {
        this.torontoWest = torontoWest;
    }

    public Double getTorontoEast() {
        return torontoEast;
    }

    public void setTorontoEast(Double torontoEast) {
        this.torontoEast = torontoEast;
    }

    public Double getWinsor() {
        return winsor;
    }

    public void setWinsor(Double winsor) {
        this.winsor = winsor;
    }

    public Double getLondon() {
        return london;
    }

    public void setLondon(Double london) {
        this.london = london;
    }

    public Double getSudbury() {
        return sudbury;
    }

    public void setSudbury(Double sudbury) {
        this.sudbury = sudbury;
    }

    public Double getThunderbay() {
        return thunderbay;
    }

    public void setThunderbay(Double thunderbay) {
        this.thunderbay = thunderbay;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString () {
        return String.format("yyyy-MM-dd","$%.2f","$%.2f","$%.2f","$%.2f",
                "$%.2f","$%.2f","$%.2f","%d",date,ottawa,torontoEast,torontoWest,winsor,
                london,sudbury,thunderbay,fuelType);
    }

}
