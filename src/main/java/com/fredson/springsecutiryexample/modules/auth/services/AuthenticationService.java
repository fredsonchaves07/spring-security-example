package com.fredson.springsecutiryexample.modules.auth.services;

import com.fredson.springsecutiryexample.modules.auth.records.AuthenticationRequest;
import com.fredson.springsecutiryexample.modules.auth.records.AuthenticationResponse;
import com.fredson.springsecutiryexample.modules.auth.records.RegisterRequest;
import com.fredson.springsecutiryexample.modules.user.entities.User;
import com.fredson.springsecutiryexample.modules.user.repositories.UserRepository;
import com.fredson.springsecutiryexample.security.CustomUserDetailsService;
import com.fredson.springsecutiryexample.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User(request.name(), request.username(), passwordEncoder.encode(request.password()));
        User existsUser = repository.findByUsername(request.username());
        if (existsUser != null) throw new Error("User already exists");
        //TODO -> Implementar o role
        repository.save(user);
        var jwtToken = jwtService.generateToken(userDetailsService.loadUserByUsername(request.username()));
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        var user = repository.findByUsername(request.username());
        if (user == null) throw new Error("User does not exist!");
        var jwtToken = jwtService.generateToken(userDetailsService.loadUserByUsername(request.username()));
        return new AuthenticationResponse(jwtToken);
    }
}
