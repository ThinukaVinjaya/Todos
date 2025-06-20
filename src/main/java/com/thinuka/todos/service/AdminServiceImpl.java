package com.thinuka.todos.service;

import com.thinuka.todos.entity.Authority;
import com.thinuka.todos.entity.User;
import com.thinuka.todos.repository.UserRepository;
import com.thinuka.todos.response.UserResponse;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public List<UserResponse> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(this::convertToUserResponse).toList();
    }

    @Override
    @Transactional
    public UserResponse prompteToAdmin(long userId) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty() || user.get().getAuthorities().stream().anyMatch(grantedAuthority -> "ROLE_ADMIN"
                .equals(authority.getAuthority()))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "User does not exist or already an admin");
        }

        List<Authority> authorities = new ArrayList<>();
        authorities.add(new Authority("ROLE_EMPLOYEE"));
        authorities.add(new Authority("ROLE_ADMIN"));
        user.get().setAuthorities(authorities);

        User savedUser = UserRepository.save(user.get());



        return convertToUserResponse(savedUser);
    }

    @Override
    @Transactional
    public void deleteNonAdminUser(long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty() || user.get().getAuthorities().stream().anyMatch(grantedAuthority -> "ROLE_ADMIN"
                .equals(authority.getAuthority()))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "User does not exist or already an admin");
        }

        userRepository.delete(user.get());
    }


    public UserResponse convertToUserResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getFirstName() + " "+ user.getLastName(),
                user.getEmail(),
                user.getAuthorities().stream().map(auth ->(Authority) auth).toList()
        );
    }
}
