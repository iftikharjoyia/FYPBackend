package com.vehicle.insurance.management.system.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "DriverDetails")
public class DriverDetails {

    @Id
    private String id; // MongoDB _id field

    private String licenseNumber;
    private LocalDateTime expiryDate;
    private int points;

    @DBRef
    private PersonalDetails owner; // Reference to the PersonalDetails collection

    // Constructors, getters, setters, and other methods

    public DriverDetails() {
        // Default constructor
    }

    public DriverDetails(String licenseNumber, LocalDateTime expiryDate, int points, PersonalDetails owner) {
        this.licenseNumber = licenseNumber;
        this.expiryDate = expiryDate;
        this.points = points;
        this.owner = owner;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public PersonalDetails getOwner() {
        return owner;
    }

    public void setOwner(PersonalDetails owner) {
        this.owner = owner;
    }
}
