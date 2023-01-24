package com.fredson.springsecutiryexample.modules.auth.controllers;

import com.fredson.springsecutiryexample.modules.auth.records.AuthenticationRequest;
import com.fredson.springsecutiryexample.modules.auth.records.AuthenticationResponse;
import com.fredson.springsecutiryexample.modules.auth.records.RegisterRequest;
import com.fredson.springsecutiryexample.modules.auth.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/autenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
