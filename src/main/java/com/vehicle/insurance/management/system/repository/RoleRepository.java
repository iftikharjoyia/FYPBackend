package com.vehicle.insurance.management.system.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vehicle.insurance.management.system.models.ERole;
import com.vehicle.insurance.management.system.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
