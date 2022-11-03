package com.tmx.nari.agm.config;

/**
 * Created by Harutyun Badeyan
 * Date: 01.11.22
 * Time: 20:40
 */
public enum JwtClaim {

    EMAIL("email"),
    SUB("sub"),
    UID("uid"),
    EXPIRATION("exp");

    private final String value;

    JwtClaim(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
