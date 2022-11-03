package com.tmx.nari.agm.config.oauth;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data

/**
 * Created by Arshavir Hunanyan
 * Date: 9/11/21
 * Time: 3:42 PM
 */
public class OauthTokenRequest {

    @NotEmpty
    @Email
    private String userName;

    @NotEmpty
    private String password;

}