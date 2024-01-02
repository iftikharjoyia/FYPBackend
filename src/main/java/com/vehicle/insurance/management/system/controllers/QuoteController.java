
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
    public ResponseEntity<DriverDetails> findByCnic(@RequestParam String license) {
        DriverDetails driverDetails =driverDetailsService.findByLicenseNumber(license);
        if (driverDetails != null) {
            return new ResponseEntity<>(driverDetails, HttpStatus.OK);
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
        String owner = request.get("owner");

        driverDetails.setExpiryDate(expiryDate);
        driverDetails.setDob(dob);

        DriverDetails driverDetails1 = driverDetailsService.addDriverDetails(driverDetails);
        if (driverDetails1 != null) {
            return new ResponseEntity<>(driverDetails1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
