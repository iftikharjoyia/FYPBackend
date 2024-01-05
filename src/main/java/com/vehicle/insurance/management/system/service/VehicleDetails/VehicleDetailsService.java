package com.vehicle.insurance.management.system.service.VehicleDetails;

import com.vehicle.insurance.management.system.models.VehicleDetails;

import java.util.List;

public interface VehicleDetailsService {

    VehicleDetails findByRegistrationNumber(String registrationNumber);

    VehicleDetails addVehicleDetails(VehicleDetails vehicleDetails);

    public List<VehicleDetails> getAllVehicles();

    public List<VehicleDetails> getVehiclesByEmail(String email) ;

    // Add other methods for CRUD operations and additional functionalities
}
