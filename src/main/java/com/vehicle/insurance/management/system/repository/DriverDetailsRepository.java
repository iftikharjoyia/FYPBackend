package com.vehicle.insurance.management.system.repository;

import com.vehicle.insurance.management.system.models.DriverDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverDetailsRepository extends MongoRepository<DriverDetails, String> {

    DriverDetails findByLicenseNumber(String licenseNumber);

    List<DriverDetails> findAll();

    List<DriverDetails> findByEmail(String email);


    // Add other repository methods if needed
}
