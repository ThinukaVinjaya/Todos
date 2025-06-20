package com.thinuka.todos.service;

import com.thinuka.todos.response.UserResponse;

import java.util.List;

public interface AdminService {
    List<UserResponse> getAllUsers();
    UserResponse prompteToAdmin(long userId);
    void deleteNonAdminUser(long userId);
}
