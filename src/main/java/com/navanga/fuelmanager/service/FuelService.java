package com.navanga.fuelmanager.service;

import com.navanga.fuelmanager.domain.FuelStationPrice;
import com.navanga.fuelmanager.domain.Station;
import com.navanga.fuelmanager.repository.FuelStationPriceRepository;
import com.navanga.fuelmanager.repository.StationRepository;
import com.navanga.fuelmanager.service.api.FuelApiService;
import com.navanga.fuelmanager.service.api.request.FuelType;
import com.navanga.fuelmanager.service.api.response.FuelLocationPricesResponse;
import com.navanga.fuelmanager.service.api.response.FuelStation;
import com.navanga.fuelmanager.service.api.response.StationPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FuelService {

    @Autowired
    private FuelApiService fuelApiService;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private FuelStationPriceRepository fuelStationPriceRepository;

    public String findPriceByStationCode(String stationCode) {
        Object priceResult = fuelApiService.findPriceByStationCode(stationCode);

        if (priceResult != null) {
            return priceResult.toString();
        }
        return "data not found";
    }

    private void saveStationPriceResult(FuelLocationPricesResponse priceResult) {

        List<FuelStation> fuelStations = List.of(priceResult.getStations());
        List<Station> stationList = new ArrayList<>();
        for (FuelStation fuelStation : fuelStations) {
            Station station = new Station();
            station.setCode(fuelStation.getCode());
            station.setName(fuelStation.getName());
            station.setAddress(fuelStation.getAddress());
            station.setBrand(fuelStation.getBrand());
            stationList.add(station);
        }

        stationRepository.saveAll(stationList);

        List<StationPrice> stationPrices = List.of(priceResult.getPrices());
        List<FuelStationPrice> stationPriceList = new ArrayList<>();
        for (StationPrice stationPrice : stationPrices) {
            FuelStationPrice fuelStationPrice = new FuelStationPrice();
            fuelStationPrice.setStationCode(stationPrice.getStationcode());
            fuelStationPrice.setFuelType(stationPrice.getFueltype());
            fuelStationPrice.setPrice(new BigDecimal(stationPrice.getPrice()));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            fuelStationPrice.setLastUpdated(LocalDateTime.parse(stationPrice.getLastupdated(), formatter));

            Station station = stationList.stream().filter(s -> s.getCode().equals(stationPrice.getStationcode())).findFirst().orElse(null);
            fuelStationPrice.setStation(station);
            stationPriceList.add(fuelStationPrice);
        }
        fuelStationPriceRepository.saveAll(stationPriceList);
    }

    public List<FuelStationPriceDTO> findPriceByLocation(String locationCode, FuelType fuelType) {
        FuelLocationPricesResponse priceResult = fuelApiService.findPriceByLocation(locationCode, fuelType);

        saveStationPriceResult(priceResult);

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
                            new BigDecimal(stationPrice.getPrice()), stationPrice.getFueltype()));
                    break;
                }
            }
        }

        return fuelStationPriceDTOList;
    }

}
