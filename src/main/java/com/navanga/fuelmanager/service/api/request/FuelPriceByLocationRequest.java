package com.navanga.fuelmanager.service.api.request;

public class FuelPriceByLocationRequest {
/**
    get_fuel_prices_for_location_request{
        fueltype*	string
        brand*	[string]
        namedlocation*	string
        referencepoint*	reference_point{
            latitude*	string
            longitude*	string
        }
        sortby*	string
        sortascending*	string
    }
 **/

    private FuelType fueltype;
    private String namedlocation;
    private String sortby;
    private String sortascending;

    public FuelPriceByLocationRequest(String namedlocation, FuelType fueltype) {
        this.namedlocation = namedlocation;
        this.fueltype = fueltype;
        setSortby("price");
        setSortascending("true");
    }

    public FuelType getFueltype() {
        return fueltype;
    }

    public void setFueltype(FuelType fueltype) {
        this.fueltype = fueltype;
    }

    public String getNamedlocation() {
        return namedlocation;
    }

    public void setNamedlocation(String namedlocation) {
        this.namedlocation = namedlocation;
    }

    public String getSortby() {
        return sortby;
    }

    public void setSortby(String sortby) {
        this.sortby = sortby;
    }

    public String getSortascending() {
        return sortascending;
    }

    public void setSortascending(String sortascending) {
        this.sortascending = sortascending;
    }
}
