
package com.vehicle.insurance.management.system.controllers;

import com.vehicle.insurance.management.system.models.DriverDetails;
import com.vehicle.insurance.management.system.models.PersonalDetails;
import com.vehicle.insurance.management.system.repository.DriverDetailsRepository;
import com.vehicle.insurance.management.system.repository.PersonalDetailRepository;
import com.vehicle.insurance.management.system.service.DriverDetailService.DriverDetailsService;
import com.vehicle.insurance.management.system.service.PersonalDetailService.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class QuoteController {

    @Autowired
    DriverDetailsRepository driverDetailsRepository;
    @Autowired
    DriverDetailsService driverDetailsService;

    @GetMapping("/findbylicense")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<DriverDetails> findByCnic(@RequestParam String license) {
        DriverDetails driverDetails =driverDetailsService.findByLicenseNumber(license);
        if (driverDetails != null) {
            return new ResponseEntity<>(driverDetails, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/addDriverDetails")
    public ResponseEntity<DriverDetails> addDriverDetails(@RequestBody Map<String, String> request) {
        String license = request.get("licenseNumber");
        DriverDetails driverDetails = driverDetailsService.findByLicenseNumber(license);

        String expiryDate = request.get("expiryDate");
        String dob = request.get("dob");
        String email = request.get("email");

        driverDetails.setExpiryDate(expiryDate);
        driverDetails.setDob(dob);
        driverDetails.setEmail(email);
//        DriverDetails driverDetails=new DriverDetails(license,expiryDate,dob,email);
        DriverDetails driverDetails1 = driverDetailsService.addDriverDetails(driverDetails);
        if (driverDetails1 != null) {
            return new ResponseEntity<>(driverDetails1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllDrivers")
    public ResponseEntity<List<DriverDetails>> getAllDrivers() {
        List<DriverDetails> allDrivers = driverDetailsService.getAllDrivers();

        if (!allDrivers.isEmpty()) {
            return new ResponseEntity<>(allDrivers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getDriverDetailsByEmail")
    public ResponseEntity<List<DriverDetails>> getDriverDetailsByEmail(@RequestParam String email) {
        List<DriverDetails> driverDetailsByEmail = driverDetailsService.getDriverByEmail(email);

        if (!driverDetailsByEmail.isEmpty()) {
            return new ResponseEntity<>(driverDetailsByEmail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
