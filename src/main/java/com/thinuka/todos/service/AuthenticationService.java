package com.thinuka.todos.service;

import com.thinuka.todos.request.AuthenticationRequest;
import com.thinuka.todos.request.RegisterRequest;
import com.thinuka.todos.response.AuthenticationResponse;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
    AuthenticationResponse login(AuthenticationRequest request);
}
