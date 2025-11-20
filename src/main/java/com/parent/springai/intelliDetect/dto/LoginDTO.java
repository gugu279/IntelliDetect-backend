package com.parent.springai.intellidetect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginDTO {
    @JsonProperty("uname")
    private String uname;
    
    @JsonProperty("passwor")  // 注意JSON中是"passwor"
    private String passwor;
    
    // 构造方法
    public LoginDTO() {}
    
    // Getter和Setter方法
    public String getUname() { return uname; }
    public void setUname(String uname) { this.uname = uname; }
    
    public String getPasswor() { return passwor; }
    public void setPasswor(String passwor) { this.passwor = passwor; }
}