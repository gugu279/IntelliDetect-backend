package com.parent.springai.intellidetect.service;

import com.parent.springai.intellidetect.entity.User;

public interface UserService {
    Long register(String username, String password, String phoneNumber, String email);
    Long login(String username, String password);
    User getUserById(Long id);
    User getUserByUsername(String username);
}