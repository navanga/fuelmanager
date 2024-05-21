package com.navanga.fuelmanager.service.api;

import com.navanga.fuelmanager.service.api.request.FuelPriceByLocationRequest;
import com.navanga.fuelmanager.service.api.request.FuelType;
import com.navanga.fuelmanager.service.api.response.FuelLocationPricesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FuelApiServiceImpl implements FuelApiService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FuelApiConfiguration apiConfig;

    @Autowired
    private FuelApiAuthorizationService apiAuthorizationService;

    @Override
    public FuelLocationPricesResponse findAllPrices() {
        logger.info("Calling findAllPrices()");

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getAccessToken());
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.add("transactionid", String.valueOf(System.currentTimeMillis()));
        headers.add("requesttimestamp", "30/04/2020 11:55:00 PM");
        headers.add("apikey", apiConfig.getApiKey());

        HttpEntity<FuelPriceByLocationRequest> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(
                        apiConfig.getAllPricesUrl(),
                        HttpMethod.GET,
                        entity, String.class);

        logger.info("Response status code: {}", response.getStatusCode());
        System.out.println(response.getBody());
        return null;

//        return response.getBody();
    }

    @Override
    public FuelLocationPricesResponse findPriceByLocation(String location, FuelType fuelType) {
        logger.info("Calling findPriceByLocation()");

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getAccessToken());
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.add("transactionid", String.valueOf(System.currentTimeMillis()));
        headers.add("requesttimestamp", "30/04/2020 11:55:00 PM");
        headers.add("apikey", apiConfig.getApiKey());

        FuelPriceByLocationRequest body = new FuelPriceByLocationRequest(location, fuelType);

        HttpEntity<FuelPriceByLocationRequest> entity = new HttpEntity<>(body, headers);

        ResponseEntity<FuelLocationPricesResponse> response =
                restTemplate.exchange(
                        apiConfig.getPriceByLocationUrl(),
                        HttpMethod.POST,
                        entity, FuelLocationPricesResponse.class);

        logger.info("Response status code: {}", response.getStatusCode());

        return response.getBody();
    }

    @Override
    public Object findPriceByStationCode(String location) {
        return null;
    }


    @Override
    public Object findPriceByGeoLocation(String latitude, String longitude, String radius) {
        return null;
    }


    public String getAccessToken() {
        return apiAuthorizationService.getAccessToken();
    }

}
