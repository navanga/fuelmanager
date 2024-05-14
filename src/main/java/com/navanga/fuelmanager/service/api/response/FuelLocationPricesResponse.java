package com.navanga.fuelmanager.service.api.response;

public class FuelLocationPricesResponse {

    /**
     * location_prices{
     * stations*	[station{
     * brand*	string
     * example: BP
     * code*	string
     * example: 301
     * name*	string
     * example: BP Naremburn
     * address*	string
     * example: 169 Willoughby Road, Naremburn NSW 2065
     * location*	{...}
     * }]
     * prices*	[price{
     * stationcode*	string
     * example: 301
     * fueltype*	string
     * example: P95
     * price*	number
     * example: 186.9
     * lastupdated*	string
     * example: 26/09/2019 02:51:27
     * }]
     * }
     */

    private FuelStation [] stations;
    private StationPrice [] prices;

    public FuelStation[] getStations() {
        return stations;
    }

    public void setStations(FuelStation[] stations) {
        this.stations = stations;
    }

    public StationPrice[] getPrices() {
        return prices;
    }

    public void setPrices(StationPrice[] prices) {
        this.prices = prices;
    }
}
