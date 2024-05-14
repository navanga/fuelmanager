package com.navanga.fuelmanager.service.api.response;

public class StationPrice {
    /**
     *   "stationcode": "1022",
     *       "fueltype": "E10",
     *       "price": 233.9,
     *       "lastupdated": "05/04/2024 01:05:36"
     */

    private String stationcode;
    private String fueltype;
    private String price;
    private String lastupdated;

    public String getStationcode() {
        return stationcode;
    }

    public void setStationcode(String stationcode) {
        this.stationcode = stationcode;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }
}
