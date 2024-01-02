package com.vehicle.insurance.management.system.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "VehicleDetails")
public class VehicleDetails {

    @Id
    private String id; // MongoDB _id field

    private String registrationNumber;
    private String model;
    private String color;
    private int year;

    private String email;

    @DBRef
    private PersonalDetails owner; // Reference to the PersonalDetails collection

    // Constructors, getters, setters, and other methods

    public VehicleDetails() {
        // Default constructor
    }

    public VehicleDetails(String registrationNumber, String model, String color, int year, PersonalDetails owner) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.color = color;
        this.year = year;
        this.owner = owner;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
