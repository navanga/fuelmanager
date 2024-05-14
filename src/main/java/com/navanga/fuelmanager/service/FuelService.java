package com.navanga.fuelmanager.service;

import com.navanga.fuelmanager.service.api.FuelApiService;
import com.navanga.fuelmanager.service.api.request.FuelType;
import com.navanga.fuelmanager.service.api.response.AccessTokenResponse;
import com.navanga.fuelmanager.service.api.response.FuelLocationPricesResponse;
import com.navanga.fuelmanager.service.api.response.FuelStation;
import com.navanga.fuelmanager.service.api.response.StationPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FuelService {

    @Autowired
    private FuelApiService fuelApiService;

    public String findPriceByStationCode(String stationCode) {
        Object priceResult = fuelApiService.findPriceByStationCode(stationCode);

        if (priceResult != null) {
            return priceResult.toString();
        }
        return "data not found";
    }

    public List<FuelStationPriceDTO> findPriceByLocation(String locationCode, FuelType fuelType) {
        FuelLocationPricesResponse priceResult = fuelApiService.findPriceByLocation(locationCode, fuelType);

        Arrays.stream(priceResult.getStations()).flatMap(s -> Arrays.stream(priceResult.getPrices())
                        .filter(p -> p.getStationcode().equals(s.getCode())))
                .map(s -> new FuelStationPriceDTO());

        List<FuelStationPriceDTO> fuelStationPriceDTOList = new ArrayList<>();

        for (FuelStation fuelStation : priceResult.getStations()) {
            for (StationPrice stationPrice : priceResult.getPrices()) {
                if (fuelStation.getCode().equals(stationPrice.getStationcode())) {
                    fuelStationPriceDTOList.add(new FuelStationPriceDTO(
                            fuelStation.getName(),
                            fuelStation.getBrand(),
                            fuelStation.getAddress(),
                            new BigDecimal(stationPrice.getPrice()),
                            stationPrice.getFueltype()));
                    break;
                }
            }
        }

        return fuelStationPriceDTOList;
    }

}
