package com.navanga.fuelmanager.service.api;

import com.navanga.fuelmanager.service.api.request.FuelPriceByLocationRequest;
import com.navanga.fuelmanager.service.api.request.FuelType;
import com.navanga.fuelmanager.service.api.response.AccessTokenResponse;
import com.navanga.fuelmanager.service.api.response.FuelLocationPricesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FuelApiServiceImpl implements FuelApiService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FuelApiAuthorizationService apiAuthorizationService;

    @Override
    public FuelLocationPricesResponse findPriceByLocation(String location, FuelType fuelType) {
        logger.info("Calling findPriceByLocation()");

        String RESOURCE_URL = "https://api.onegov.nsw.gov.au/FuelPriceCheck/v1/fuel/prices/location";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getAccessToken());
        headers.add("Content-Type", "application/json");
        headers.add("transactionid", "1");
        headers.add("requesttimestamp", "30/04/2020 11:55:00 PM");
        headers.add("apikey", "zAe8LH7APwOo3jOT5On0hs77Sqs00lUk");

        FuelPriceByLocationRequest body = new FuelPriceByLocationRequest(location, fuelType);

        HttpEntity<FuelPriceByLocationRequest> entity = new HttpEntity<>(body, headers);

        ResponseEntity<FuelLocationPricesResponse> response =
                restTemplate.exchange(
                        RESOURCE_URL,
                        HttpMethod.POST,
                        entity, FuelLocationPricesResponse.class);
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
