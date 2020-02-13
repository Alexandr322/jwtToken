package com.jwt.tokenMongo.exception;

import io.jsonwebtoken.SignatureException;

public class JwtCustomException extends SignatureException {

    public JwtCustomException(String message) {
        super(message);
    }
}