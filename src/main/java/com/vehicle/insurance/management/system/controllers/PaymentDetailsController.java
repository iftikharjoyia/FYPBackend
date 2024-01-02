package com.vehicle.insurance.management.system.controllers;


import com.vehicle.insurance.management.system.models.PaymentDetails;
import com.vehicle.insurance.management.system.service.PaymentDetailsService.PaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentDetailsController {
    @Autowired
    private PaymentDetailsService paymentDetailsService;

    @Autowired
    public PaymentDetailsController(PaymentDetailsService paymentDetailsService) {
        this.paymentDetailsService = paymentDetailsService;
    }

    @PostMapping("/addPaymentDetails")
    public ResponseEntity<PaymentDetails> savePaymentDetails(@RequestBody PaymentDetails paymentDetails) {
        PaymentDetails savedDetails = paymentDetailsService.savePaymentDetails(paymentDetails);
        return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
    }

    // Add other endpoints for CRUD operations and additional functionalities
}
