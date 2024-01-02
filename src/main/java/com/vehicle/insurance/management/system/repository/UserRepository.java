package com.vehicle.insurance.management.system.repository;

import java.util.List;
import java.util.Optional;

import com.vehicle.insurance.management.system.models.ERole;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.vehicle.insurance.management.system.models.User;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  User findByEmail(String email);

  List<User> getUserByRoles(String role);
}
