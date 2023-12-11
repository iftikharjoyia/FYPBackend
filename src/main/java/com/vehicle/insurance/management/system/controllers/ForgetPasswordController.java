package com.vehicle.insurance.management.system.controllers;

import com.vehicle.insurance.management.system.models.User;
import com.vehicle.insurance.management.system.payload.response.MessageResponse;
import com.vehicle.insurance.management.system.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/email")
public class ForgetPasswordController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/changepassword")
    public ResponseEntity<?> changePassword(@RequestBody Map<String, String> request, HttpSession session) {
        String newPassword = request.get("password");
        String email = request.get("to");

        User user = userRepository.findByEmail(email);


        if (user == null) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("User not found"));
        }

        // Encode the new password before saving it
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        try {
            userRepository.save(user);
            return ResponseEntity.ok(new MessageResponse("Password Updated"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Password did not change"));
        }
    }
}
