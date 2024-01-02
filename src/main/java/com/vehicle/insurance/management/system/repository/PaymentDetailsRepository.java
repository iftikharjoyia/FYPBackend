package com.vehicle.insurance.management.system.repository;


import com.vehicle.insurance.management.system.models.PaymentDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends MongoRepository<PaymentDetails, Long> {
    // Add any additional repository methods if needed
}
