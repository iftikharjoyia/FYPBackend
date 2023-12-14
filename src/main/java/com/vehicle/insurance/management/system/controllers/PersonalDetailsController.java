package com.vehicle.insurance.management.system.controllers;

import com.vehicle.insurance.management.system.models.PersonalDetails;
import com.vehicle.insurance.management.system.repository.PersonalDetailRepository;
import com.vehicle.insurance.management.system.service.PersonalDetailService.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/personal-details")
public class PersonalDetailsController {

    private final PersonalDetailsService personalDetailsService;

    @Autowired
    private PersonalDetailRepository personalDetailRepository;
    @Autowired
    public PersonalDetailsController(PersonalDetailsService personalDetailsService) {
        this.personalDetailsService = personalDetailsService;
    }

    @GetMapping("/findbycnic")
    public ResponseEntity<PersonalDetails> findByCnic(@RequestParam String cnic) {
        PersonalDetails personalDetails = personalDetailsService.findByCnic(cnic);
        if (personalDetails != null) {
            return new ResponseEntity<>(personalDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/addPersonalDetails")
    public ResponseEntity<PersonalDetails> addPersonalDetails(@RequestBody Map<String,String> request) {
        String cnic=request.get("cnic");
        String name=request.get("name");
        String verificationDate=request.get("verificationDate");
        String verificationStatus=request.get("verificationStatus");
        String email=request.get("email");

        PersonalDetails personalDetailsData=new PersonalDetails(cnic,name,verificationDate,verificationStatus,email);

        PersonalDetails personalDetails = personalDetailRepository.save(personalDetailsData);
        if (personalDetails != null) {
            return new ResponseEntity<>(personalDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}