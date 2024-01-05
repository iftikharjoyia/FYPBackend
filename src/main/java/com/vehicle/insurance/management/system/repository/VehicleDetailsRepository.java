package com.vehicle.insurance.management.system.repository;

import com.vehicle.insurance.management.system.models.VehicleDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDetailsRepository extends MongoRepository<VehicleDetails, String> {

    VehicleDetails findByRegistrationNumber(String registrationNumber);
    public List<VehicleDetails> findAll();

    List<VehicleDetails> findByEmail(String email);

    // Add other repository methods if needed
}
