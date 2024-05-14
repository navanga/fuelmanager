package com.navanga.fuelmanager.service.api.response;

public class AccessTokenResponse {

    /**
     * refresh_token_expires_in*	string
     * api_product_list_json*	[...]
     * organization_name*	string
     * example: onegov
     * developer.email*	string
     * token_type*	string
     * example: BearerToken
     * issued_at*	string
     * example: 1569816768267
     * client_id*	string
     * access_token*	string
     * application_name*	string
     * scope*	string
     * expires_in*	string
     * refresh_count*	string
     * status*	string
     */


    private String access_token;
    private String token_type;
    private String expires_in;
    private String refresh_token;
    private String scope;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "AccessTokenResponse{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
