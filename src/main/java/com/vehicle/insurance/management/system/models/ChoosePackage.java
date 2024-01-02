package com.vehicle.insurance.management.system.models;

import org.springframework.data.annotation.Id;

public class ChoosePackage {
    @Id
    private String id;

    private String packageName;
    private String email;

    // Default constructor
    public ChoosePackage() {
    }

    // Constructor with parameters
    public ChoosePackage(String packageName, String email) {
        this.packageName = packageName;
        this.email = email;
    }

    // Getter and setter methods

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
