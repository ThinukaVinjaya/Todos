package com.thinuka.todos.service;


import com.thinuka.todos.request.PasswordUpdateRequest;
import com.thinuka.todos.response.UserResponse;

public interface UserService {

    UserResponse getUserInfo();
    void deleteUser();
    void updatePassword(PasswordUpdateRequest passwordUpdateRequest);
}

