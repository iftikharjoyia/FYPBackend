package com.vehicle.insurance.management.system.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "DriverDetails")
public class DriverDetails {

    @Id
    private String licenseNumber;
    private String expiryDate;
    private String dob;
    private String email;

    @DBRef
    private PersonalDetails owner; // Reference to the PersonalDetails collection

    // Constructors, getters, setters, and other methods

    public DriverDetails() {
        // Default constructor
    }

    public DriverDetails(String licenseNumber, String expiryDate, String dob, PersonalDetails owner) {
        this.licenseNumber = licenseNumber;
        this.expiryDate = expiryDate;
        this.dob = dob;
        this.owner = owner;
    }

    // Getters and setters



    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String points) {
        this.dob = dob;
    }

    public PersonalDetails getOwner() {
        return owner;
    }

    public void setOwner(PersonalDetails owner) {
        this.owner = owner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
