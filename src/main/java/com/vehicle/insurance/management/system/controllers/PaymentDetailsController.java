package com.vehicle.insurance.management.system.controllers;


import com.vehicle.insurance.management.system.models.PaymentDetails;
import com.vehicle.insurance.management.system.service.EmailService;
import com.vehicle.insurance.management.system.service.PaymentDetailsService.PaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class PaymentDetailsController {
    @Autowired
    private PaymentDetailsService paymentDetailsService;

    @Autowired
    public PaymentDetailsController(PaymentDetailsService paymentDetailsService) {
        this.paymentDetailsService = paymentDetailsService;
    }
    @Autowired
    private EmailService emailService;
    @PostMapping("/addPaymentDetails")
    public ResponseEntity<PaymentDetails> savePaymentDetails(@RequestBody Map<String,String> request) throws MessagingException {
        String name=request.get("cardHolderName");
        String cardNumber=request.get("cardNumber");
        String expiryDate=request.get("expiryDate");
        int cvv= Integer.parseInt(request.get("cvv"));
        String email=request.get("email");
        PaymentDetails paymentDetails=new PaymentDetails(cardNumber,name,expiryDate,cvv,email);
        PaymentDetails savedDetails = paymentDetailsService.savePaymentDetails(paymentDetails);
        if(savedDetails!=null){
            emailService.sendEmail(paymentDetails.getEmail(), "Congrats! Your payment has beed recieved", "");

        }
        return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
    }



}
