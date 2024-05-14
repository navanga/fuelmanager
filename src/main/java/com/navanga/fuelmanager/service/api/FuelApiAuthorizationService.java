package com.navanga.fuelmanager.service.api;

import com.navanga.fuelmanager.domain.AccessToken;
import com.navanga.fuelmanager.domain.AccessTokenRepository;
import com.navanga.fuelmanager.service.api.response.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FuelApiAuthorizationService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String RESOURCE_URL = "https://api.onegov.nsw.gov.au/oauth/client_credential/accesstoken?grant_type=client_credentials";
    public static final String AUTH_HEADER = "Basic ekFlOExIN0FQd09vM2pPVDVPbjBoczc3U3FzMDBsVWs6TzdyV2tTUTNyZUZJb3hrNg==";

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    public AccessTokenResponse generateAccessToken() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", AUTH_HEADER);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<AccessTokenResponse> response =
                restTemplate.exchange(
                        RESOURCE_URL,
                        HttpMethod.GET,
                        entity, AccessTokenResponse.class);

        return response.getBody();

    }

    public String getAccessToken() {

        String accessToken;
        List<AccessToken> accessTokenList = accessTokenRepository.findAll();
        if (isTokenValid(accessTokenList)) {
            accessToken = "Bearer " + accessTokenList.get(0).getToken();
        } else {
            AccessTokenResponse tokenResponse = generateAccessToken();
            AccessToken accessTokenEntity = new AccessToken();
            accessTokenEntity.setToken(tokenResponse.getAccess_token());
            accessTokenEntity.setExpires(LocalDateTime.now().plusSeconds(Integer.parseInt(tokenResponse.getExpires_in())));
            accessTokenRepository.save(accessTokenEntity);
            accessToken = "Bearer " + tokenResponse.getAccess_token();
        }
        return accessToken;
    }


    /**
     * Check if token is expired
     *
     * @return
     */
    private boolean isTokenValid(List<AccessToken> accessTokenList) {

        if (!CollectionUtils.isEmpty(accessTokenList)) {
            if (LocalDateTime.now().isBefore(accessTokenList.get(0).getExpires())) {
                return true;
            }
        }
        return false;
    }
}
