package com.navanga.fuelmanager.service.api;

import com.navanga.fuelmanager.service.api.request.FuelType;
import com.navanga.fuelmanager.service.api.response.AccessTokenResponse;
import com.navanga.fuelmanager.service.api.response.FuelLocationPricesResponse;

public interface FuelApiService {

    /**
     * Get fuel prices for station
     * @param stationCode
     * @return
     */
    Object findPriceByStationCode(String stationCode);

    /**
     * Returns current fuel prices for a single fuel type and a named location (ie Suburb or postcode)
     * @param location
     * @return
     */
    FuelLocationPricesResponse findPriceByLocation(String location, FuelType fuelType);

    /**
     * Returns current fuel prices for a single fuel type within a specified radius from a reference point.
     * If no stations exist within the radius then fuel prices for the closest 10 stations are returned.
     * @param latitude
     * @param longitude
     * @param radius
     * @return
     */
    Object findPriceByGeoLocation(String latitude, String longitude, String radius);

    /**
     * Returns all current fuel prices for all service stations.
     * @return
     */
    FuelLocationPricesResponse findAllPrices();

}
