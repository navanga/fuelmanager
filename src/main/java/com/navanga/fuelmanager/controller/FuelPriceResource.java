package com.navanga.fuelmanager.controller;

import com.navanga.fuelmanager.service.FuelService;
import com.navanga.fuelmanager.service.FuelStationPriceDTO;
import com.navanga.fuelmanager.service.api.request.FuelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class FuelPriceResource {

    @Autowired
    private FuelService fuelService;

    //http://localhost:8080/fuel-station-prices?postCode=2155
    @GetMapping(value = "fuel-station-prices")
    public List<FuelStationPriceDTO> getFuelStationPrices(@RequestParam String postCode){
        return fuelService.findPriceByLocation(postCode, FuelType.E10);
    }

}
