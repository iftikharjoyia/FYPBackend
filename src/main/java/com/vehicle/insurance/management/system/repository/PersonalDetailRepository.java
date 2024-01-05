package com.vehicle.insurance.management.system.repository;

import com.vehicle.insurance.management.system.models.PersonalDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalDetailRepository extends MongoRepository<PersonalDetails,String> {
    PersonalDetails findByCnic(String cnic);
    List<PersonalDetails> findAll();

    List<PersonalDetails> findByEmail(String email);

}
