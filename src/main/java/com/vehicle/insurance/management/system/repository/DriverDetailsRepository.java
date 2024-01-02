package com.vehicle.insurance.management.system.repository;

import com.vehicle.insurance.management.system.models.DriverDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDetailsRepository extends MongoRepository<DriverDetails, String> {

    DriverDetails findByLicenseNumber(String licenseNumber);

    // Add other repository methods if needed
}
