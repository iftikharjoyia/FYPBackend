package com.vehicle.insurance.management.system.controllers;


import com.vehicle.insurance.management.system.models.User;
import com.vehicle.insurance.management.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // Adjust the base path according to your preference
public class AgentController {

    @Autowired
    private UserRepository userRepository;


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
    public ResponseEntity<List<User>> getAgentsByRole(@RequestParam String role) {
        String roles="ROLE_MODERATOR";
        List<User> agents = userRepository.getUserByRoles(roles);

        if (!agents.isEmpty()) {
            return new ResponseEntity<>(agents, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Add other endpoints for CRUD operations and additional functionalities
}
