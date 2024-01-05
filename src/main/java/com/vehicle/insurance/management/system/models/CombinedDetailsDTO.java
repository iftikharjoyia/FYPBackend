package com.vehicle.insurance.management.system.models;

public class CombinedDetailsDTO {
    private String cnic;
    private String name;
    private String email;
    private String licenseNumber;
    private String expiryDate;
    private String dob;
    private String registrationNumber;
    private String color;
    private String model;
    private int year;

    // Constructors, getters, and setters

    public CombinedDetailsDTO() {
    }

    public CombinedDetailsDTO(String cnic, String name, String email, String licenseNumber, String expiryDate, String dob, String registrationNumber, String color, String model, int year) {
        this.cnic = cnic;
        this.name = name;
        this.email = email;
        this.licenseNumber = licenseNumber;
        this.expiryDate = expiryDate;
        this.dob = dob;
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
