package com.vehicle.insurance.management.system.payload.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class UserInfoResponse {
  private String id;
  private String username;


  private String phoneNumber;
  private String email;
  private List<String> roles;

  public UserInfoResponse(String id, String username, String email, String phoneNumber,List<String> roles) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.phoneNumber=phoneNumber;
    this.roles = roles;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<String> getRoles() {
    return roles;
  }
}
