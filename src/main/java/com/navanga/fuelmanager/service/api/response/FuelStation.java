package com.navanga.fuelmanager.service.api.response;

public class FuelStation {

    /*
    "brand": "Costco",
      "code": "2430",
      "name": "Costco Marsden Park (Members only)",
      "address": "10 Langford Drive, MARSDEN PARK NSW 2765",
      "location": {
        "latitude": -33.722985,
        "longitude": 150.840858,
        "distance": 0.0
      }
     */

    private String brand;
    private String code;
    private String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
