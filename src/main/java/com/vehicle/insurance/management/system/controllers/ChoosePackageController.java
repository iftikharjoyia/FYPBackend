package com.vehicle.insurance.management.system.controllers;


import com.vehicle.insurance.management.system.models.ChoosePackage;
import com.vehicle.insurance.management.system.service.ChoosePackageService.ChoosePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/choose-package")
public class ChoosePackageController {

    @Autowired
    private ChoosePackageService choosePackageService;

    @Autowired
    public ChoosePackageController(ChoosePackageService choosePackageService) {
        this.choosePackageService = choosePackageService;
    }

    @PostMapping("/save")
    public ResponseEntity<ChoosePackage> saveChoosePackage(@RequestBody ChoosePackage choosePackage) {
        ChoosePackage savedPackage = choosePackageService.saveChoosePackage(choosePackage);
        return new ResponseEntity<>(savedPackage, HttpStatus.CREATED);
    }

    // Add other endpoints for CRUD operations and additional functionalities
}
