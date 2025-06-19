package com.thinuka.todos.util;

import com.thinuka.todos.entity.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;

@Component
public class FindAuthenticationImpl implements FindAuthenticatedUser{

    @Override
    public User getAuthenticatedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()|| authentication.getPrincipal().equals("anonymosUser")){
            throw new AccessDeniedException("Authentication requard");
        }
        return User user =  (User) authentication.getPrinciple();

    }


}
