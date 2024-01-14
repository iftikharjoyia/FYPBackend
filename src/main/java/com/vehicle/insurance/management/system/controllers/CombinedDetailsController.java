package com.vehicle.insurance.management.system.controllers;

import com.vehicle.insurance.management.system.models.CombinedDetailsDTO;

import com.vehicle.insurance.management.system.service.combinedDetailService.CombinedDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class CombinedDetailsController {

    private final CombinedDetailsService combinedDetailsService;



    @Autowired
    public CombinedDetailsController(CombinedDetailsService combinedDetailsService) {
        this.combinedDetailsService = combinedDetailsService;
    }

    @GetMapping("/getCombinedDetails")
    public ResponseEntity<List<CombinedDetailsDTO>> getCombinedDetails() {
        List<CombinedDetailsDTO> combinedDetailsList = combinedDetailsService.getCombinedDetails();

        if (!combinedDetailsList.isEmpty()) {
            return new ResponseEntity<>(combinedDetailsList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCombinedDetailsByEmail")
    public ResponseEntity<List<CombinedDetailsDTO>> getCombinedDetailsByEmail(@RequestParam String email) {
        List<CombinedDetailsDTO> combinedDetailsList = combinedDetailsService.getCombinedDetailsByEmail(email);

        if (!combinedDetailsList.isEmpty()) {
            return new ResponseEntity<>(combinedDetailsList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
