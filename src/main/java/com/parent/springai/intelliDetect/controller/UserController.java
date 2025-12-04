// UserController.java 保持不变，但为了完整性，这里重新提供
package com.parent.springai.intellidetect.controller;

import com.parent.springai.intellidetect.dto.LoginDTO;
import com.parent.springai.intellidetect.dto.UserDTO;
import com.parent.springai.intellidetect.entity.User;
import com.parent.springai.intellidetect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO loginDTO) {
        try {
            User user = userService.login(loginDTO.getUname(), loginDTO.getPasswor());
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "登录成功");
            
            Map<String, Object> data = new HashMap<>();
            data.put("token", "obstacle-token-" + user.getId()); // 简化的token生成
            data.put("user", user);
            response.put("data", data);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody UserDTO userDTO) {
        try {
            Long userId = userService.register(userDTO.getUname(), userDTO.getPasswor(), 
                                             userDTO.getPhoneNumber(), userDTO.getEmail());
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "注册成功");
            
            Map<String, Object> data = new HashMap<>();
            data.put("id", userId);
            response.put("data", data);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "获取用户信息成功");
            response.put("data", user);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/info/{uname}")
    public ResponseEntity<Map<String, Object>> getUserByUsername(@PathVariable String uname) {
        try {
            User user = userService.getUserByUsername(uname);
            
            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);
            response.put("message", "获取用户信息成功");
            response.put("data", user);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}