package com.tmx.nari.agm.config.oauth;

import lombok.Data;

/**
 * Created by Arshavir Hunanyan
 * Date: 9/11/21
 * Time: 3:56 AM
 */
@Data
public class OauthTokenResponse {

    private final String accessToken;

    public OauthTokenResponse(String accessToken) {
        this.accessToken = accessToken;
        
    }

    public static OauthTokenResponse from(OauthToken oauthToken) {
        return new OauthTokenResponse(oauthToken.getAccessToken());
    }


}
