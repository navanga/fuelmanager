package com.navanga.fuelmanager.scheduler;

import com.navanga.fuelmanager.service.FuelService;
import com.navanga.fuelmanager.service.FuelStationPriceDTO;
import com.navanga.fuelmanager.service.api.request.FuelType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class LocationPriceRetrievalScheduledTask {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FuelService fuelService;

    @Scheduled(fixedRate = 100000)
    public void runTask() {
//        List<FuelStationPriceDTO> priceDTOList = fuelService.findAllPrices();
//
//        priceDTOList.forEach(fuelStationPriceDTO -> logger.info(fuelStationPriceDTO.toString()));

    }


}
