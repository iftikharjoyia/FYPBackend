package com.vehicle.insurance.management.system.controllers;

import com.vehicle.insurance.management.system.models.VehicleDetails;
import com.vehicle.insurance.management.system.service.VehicleDetails.VehicleDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<VehicleDetails> addVehicleDetails(@RequestBody VehicleDetails vehicleDetails) {
        VehicleDetails addedVehicleDetails = vehicleDetailsService.addVehicleDetails(vehicleDetails);
        if (addedVehicleDetails != null) {
            return new ResponseEntity<>(addedVehicleDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Add other endpoints for CRUD operations and additional functionalities
}
