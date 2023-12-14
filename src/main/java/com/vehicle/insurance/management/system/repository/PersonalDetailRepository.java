package com.vehicle.insurance.management.system.repository;

import com.vehicle.insurance.management.system.models.PersonalDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailRepository extends MongoRepository<PersonalDetails,String> {
    PersonalDetails findByCnic(String cnic);
}
