package com.fredson.springsecutiryexample.security;

import com.fredson.springsecutiryexample.modules.user.entities.User;
import com.fredson.springsecutiryexample.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User existUser = userRepository.findByUsernameFetchRoles(username);
        User existUser = userRepository.findByUsername(username);
        if (existUser == null) throw new Error("User does not exist!");
        return UserPrincipal.create(existUser);
    }
}
