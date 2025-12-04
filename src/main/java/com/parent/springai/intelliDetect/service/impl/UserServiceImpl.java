package com.parent.springai.intellidetect.service.impl;

import com.parent.springai.intellidetect.entity.User;
import com.parent.springai.intellidetect.repository.UserRepository;
import com.parent.springai.intellidetect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Long register(String username, String password, String phoneNumber, String email) {
        // 检查用户名是否已存在
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("用户名已存在");
        }
        
        // 检查邮箱是否已存在
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("邮箱已存在");
        }
        
        // 检查手机号是否已存在
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new RuntimeException("手机号已存在");
        }
        
        // 创建新用户
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashPassword(password));  // 使用简单的哈希加密
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setRole(2); // 普通用户
        
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
    
    @Override
    public User login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (verifyPassword(password, user.getPassword())) {
                return user; // 返回整个用户对象
            }
        }
        throw new RuntimeException("用户名或密码错误");
    }
    
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
    }
    
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
    }
    
    // 简单的密码哈希方法（用于演示，生产环境建议使用更安全的加密）
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("密码加密失败", e);
        }
    }
    
    // 验证密码
    private boolean verifyPassword(String inputPassword, String storedHash) {
        String inputHash = hashPassword(inputPassword);
        return inputHash.equals(storedHash);
    }
}