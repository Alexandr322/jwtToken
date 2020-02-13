package com.jwt.tokenMongo.controller;

import com.jwt.tokenMongo.model.AuthRequest;
import com.jwt.tokenMongo.model.AuthResponse;
import com.jwt.tokenMongo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class JwtAuthenticationController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationController(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> createToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(), authRequest.getPassword())
            );
        }catch (Exception ex){
            throw new Exception();
        }
        final String token = jwtUtil.createToken(authRequest.getUsername());

        return ResponseEntity.ok(new AuthResponse(token));
    }
}