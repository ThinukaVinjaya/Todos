package com.thinuka.todos.request;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AuthenticationRequest {


    @NotEmpty(message = "Email is medatory")
    @Email(message = "Invalid email format")
    private String email;

    @NotEmpty(message = "Password is madatory")
    @Size(min = 5, max = 30, message = "Password must be at least 3 characters long")
    private String password;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
