package com.vehicle.insurance.management.system.service.VehicleDetails;

import com.vehicle.insurance.management.system.models.VehicleDetails;

public interface VehicleDetailsService {

    VehicleDetails findByRegistrationNumber(String registrationNumber);

    VehicleDetails addVehicleDetails(VehicleDetails vehicleDetails);

    // Add other methods for CRUD operations and additional functionalities
}
