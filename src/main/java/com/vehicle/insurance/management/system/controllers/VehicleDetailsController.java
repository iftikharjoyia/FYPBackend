package com.vehicle.insurance.management.system.controllers;

import com.vehicle.insurance.management.system.models.VehicleDetails;
import com.vehicle.insurance.management.system.service.VehicleDetails.VehicleDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class VehicleDetailsController {

    @Autowired
    private VehicleDetailsServiceImpl vehicleDetailsService;

    @GetMapping("/findByRegistrationNumber")
    public ResponseEntity<VehicleDetails> findByRegistrationNumber(@RequestParam String registrationNumber) {
        VehicleDetails vehicleDetails = vehicleDetailsService.findByRegistrationNumber(registrationNumber);
        if (vehicleDetails != null) {
            return new ResponseEntity<>(vehicleDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addVehicleDetails")
    public ResponseEntity<VehicleDetails> addVehicleDetails(@RequestBody Map<String, String> request) {
        // Extracting data from the map
        String registrationNumber = request.get("registrationNumber");
        VehicleDetails vehicleDetails = vehicleDetailsService.findByRegistrationNumber(registrationNumber);

        String model = request.get("model");
        String color = request.get("color");
        int year = Integer.parseInt(request.get("year"));
        String email = request.get("email");
        vehicleDetails.setModel(model);
        vehicleDetails.setColor(color);
        vehicleDetails.setYear(year);
        vehicleDetails.setEmail(email);


        // Creating a VehicleDetails object
        VehicleDetails vehicleDetailsData = vehicleDetailsService.addVehicleDetails(vehicleDetails);

        if (vehicleDetailsData != null) {
            return new ResponseEntity<>(vehicleDetailsData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllVehicles")
    public ResponseEntity<List<VehicleDetails>> getAllVehicles() {
        List<VehicleDetails> allVehicles = vehicleDetailsService.getAllVehicles();

        if (!allVehicles.isEmpty()) {
            return new ResponseEntity<>(allVehicles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getVehiclesByEmail")
    public ResponseEntity<List<VehicleDetails>> getVehiclesByEmail(@RequestParam String email) {
        List<VehicleDetails> vehiclesByEmail = vehicleDetailsService.getVehiclesByEmail(email);

        if (!vehiclesByEmail.isEmpty()) {
            return new ResponseEntity<>(vehiclesByEmail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Add other endpoints for CRUD operations and additional functionalities
}
