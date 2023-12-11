package com.vehicle.insurance.management.system.repository;

import com.vehicle.insurance.management.system.models.UserOTP;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserOTPRepository extends MongoRepository<UserOTP,String> {


    UserOTP findByEmail(String email);
}
