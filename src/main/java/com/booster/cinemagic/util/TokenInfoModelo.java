package com.booster.cinemagic.util;

public class TokenInfoModelo {

    private final String jwtToken;

    public TokenInfoModelo(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }
}
