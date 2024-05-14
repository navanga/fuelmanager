package com.navanga.fuelmanager.service;

import com.navanga.fuelmanager.service.api.request.FuelType;

import java.io.Serializable;
import java.math.BigDecimal;

public class FuelStationPriceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String stationName;
    private String stationBrand;
    private String address;
    private BigDecimal price;
    private String fuelType;

    public FuelStationPriceDTO() {}

    public FuelStationPriceDTO(String stationName, String stationBrand, String address, BigDecimal price, String fuelType) {
        this.stationName = stationName;
        this.stationBrand = stationBrand;
        this.address = address;
        this.price = price;
        this.fuelType = fuelType;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationBrand() {
        return stationBrand;
    }

    public void setStationBrand(String stationBrand) {
        this.stationBrand = stationBrand;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "FuelStationPriceDTO{" +
                "stationName='" + stationName + '\'' +
                ", stationBrand='" + stationBrand + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }

    //builder pattern

}
