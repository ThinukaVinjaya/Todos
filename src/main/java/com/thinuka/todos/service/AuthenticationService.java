package com.thinuka.todos.service;

import com.thinuka.todos.request.RegisterRequest;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
}
