package com.vehicle.insurance.management.system.repository;

import com.vehicle.insurance.management.system.models.VehicleDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDetailsRepository extends MongoRepository<VehicleDetails, String> {

    VehicleDetails findByRegistrationNumber(String registrationNumber);

    // Add other repository methods if needed
}
