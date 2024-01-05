package com.vehicle.insurance.management.system.models;

import java.util.List;

public class CombinedDetails {

    private List<VehicleDetails> vehicles;
    private List<DriverDetails> drivers;
    private List<PersonalDetails> personals;

    // Constructors, getters, and setters

    public CombinedDetails(List<VehicleDetails> vehicles, List<DriverDetails> drivers, List<PersonalDetails> personals) {
        this.vehicles = vehicles;
        this.drivers = drivers;
        this.personals = personals;
    }

    // Other methods as needed
}
