package com.vehicle.insurance.management.system.service.VehicleDetails;

import com.vehicle.insurance.management.system.models.VehicleDetails;
import com.vehicle.insurance.management.system.repository.VehicleDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleDetailsServiceImpl implements VehicleDetailsService {

    private final VehicleDetailsRepository vehicleDetailsRepository;

    @Autowired
    public VehicleDetailsServiceImpl(VehicleDetailsRepository vehicleDetailsRepository) {
        this.vehicleDetailsRepository = vehicleDetailsRepository;
    }

    @Override
    public VehicleDetails findByRegistrationNumber(String registrationNumber) {
        return vehicleDetailsRepository.findByRegistrationNumber(registrationNumber);
    }

    @Override
    public VehicleDetails addVehicleDetails(VehicleDetails vehicleDetails) {
        return vehicleDetailsRepository.save(vehicleDetails);
    }

    // Implement other service methods for CRUD operations and additional functionalities
}
