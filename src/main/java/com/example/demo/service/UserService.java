package com.example.demo.service;

import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.models.User;

public interface UserService {
    void addUser(User user);
    boolean existUsername(String username);

    boolean passLogin(LoginRequestDTO loginRequest);
}
