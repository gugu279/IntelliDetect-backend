package com.parent.springai.intellidetect.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long id;
    
    @Column(name = "uname", nullable = false, unique = true, length = 50)
    @JsonProperty("uname")  // 添加这一行
    private String username;
    
    @Column(name = "password", nullable = false, length = 300)
    @JsonProperty("passwor")  // 添加这一行，注意JSON中是"passwor"不是"password"
    private String password;
    
    @Column(name = "phone_number", nullable = false, length = 20)
    @JsonProperty("phone_number")  // 添加这一行
    private String phoneNumber;
    
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    
    @Column(name = "role", nullable = false)
    private Integer role = 2;
    
    // 构造方法、getter和setter保持不变
    public User() {}
    
    public User(String username, String password, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    // Getter和Setter方法保持不变
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Integer getRole() { return role; }
    public void setRole(Integer role) { this.role = role; }
}