package com.vehicle.insurance.management.system.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "PersonalDetails")
public class PersonalDetails {


    @Id
    private String cnic;

    private String name;
    private String verificationDate;
    private String verificationStatus;

    private String email;

    // Constructors, getters, setters, and other methods

    public PersonalDetails() {
        // Default constructor
    }

    public PersonalDetails(String cnic, String name, String verificationDate, String verificationStatus,String email) {
        this.cnic = cnic;
        this.name = name;
        this.verificationDate = verificationDate;
        this.verificationStatus = verificationStatus;
        this.email=email;
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

    public String getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(String verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String isVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // Other constructors, getters, setters, and methods as needed
}
