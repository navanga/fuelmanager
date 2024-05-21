package com.navanga.fuelmanager.service.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FuelApiConfiguration {

    @Value("${fuel.api.auth.url}")
    private String authorizationUrl;

    @Value("${fuel.api.all.prices.url}")
    private String allPricesUrl;

    @Value("${fuel.api.price.location.url}")
    private String priceByLocationUrl;

    @Value("${fuel.api.auth.header}")
    private String authHeader;

    @Value("${fuel.api.key}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getAuthHeader() {
        return authHeader;
    }

    public void setAuthHeader(String authHeader) {
        this.authHeader = authHeader;
    }

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }

    public String getAllPricesUrl() {
        return allPricesUrl;
    }

    public void setAllPricesUrl(String allPricesUrl) {
        this.allPricesUrl = allPricesUrl;
    }

    public String getPriceByLocationUrl() {
        return priceByLocationUrl;
    }

    public void setPriceByLocationUrl(String priceByLocationUrl) {
        this.priceByLocationUrl = priceByLocationUrl;
    }
}
