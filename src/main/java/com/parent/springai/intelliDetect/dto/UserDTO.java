package com.parent.springai.intellidetect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    @JsonProperty("uname")
    private String uname;
    
    @JsonProperty("passwor")  // 注意JSON中是"passwor"
    private String passwor;
    
    @JsonProperty("phone_number")
    private String phoneNumber;
    
    @JsonProperty("email")
    private String email;
    
    // 构造方法
    public UserDTO() {}
    
    // Getter和Setter方法
    public String getUname() { return uname; }
    public void setUname(String uname) { this.uname = uname; }
    
    public String getPasswor() { return passwor; }
    public void setPasswor(String passwor) { this.passwor = passwor; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}