package com.vehicle.insurance.management.system.repository;

import com.vehicle.insurance.management.system.models.ChoosePackage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoosePackageRepository extends MongoRepository<ChoosePackage, String> {
    // Add any additional repository methods if needed
}
