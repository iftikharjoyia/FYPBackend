package com.vehicle.insurance.management.system.controllers;


import com.vehicle.insurance.management.system.models.ERole;
import com.vehicle.insurance.management.system.models.Role;
import com.vehicle.insurance.management.system.models.User;
import com.vehicle.insurance.management.system.repository.RoleRepository;
import com.vehicle.insurance.management.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.vehicle.insurance.management.system.models.ERole.ROLE_MODERATOR;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api") // Adjust the base path according to your preference
public class AgentController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @PutMapping("/activateAgent")
    public ResponseEntity<User> activateAgentByEmail(@RequestParam String email) {
        User agent = userRepository.findByEmail(email);

        if (agent != null) {
            agent.setStatus("Verified");
            userRepository.save(agent);
            return new ResponseEntity<>(agent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllByRole")
    public List<User> getAgentsByRole(@RequestParam String role) {
            List<User> allUsers = userRepository.findAll();
            ERole roll=ROLE_MODERATOR;
            return allUsers.stream()
                    .filter(user -> user.getRoles().stream().anyMatch(roles ->roll.equals(roles.getName())))
                    .collect(Collectors.toList());

    }

}


