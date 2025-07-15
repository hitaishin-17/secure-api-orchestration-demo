package com.example.orchestration.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: Replace this with DB call
        if ("test".equals(username)) {
            return new User("test", "{noop}test123", new ArrayList<>()); // {noop} disables password encoding
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}