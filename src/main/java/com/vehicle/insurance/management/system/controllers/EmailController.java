package com.vehicle.insurance.management.system.controllers;

import com.vehicle.insurance.management.system.models.User;
import com.vehicle.insurance.management.system.models.UserOTP;
import com.vehicle.insurance.management.system.payload.response.MessageResponse;
import com.vehicle.insurance.management.system.payload.response.UserInfoResponse;
import com.vehicle.insurance.management.system.repository.UserOTPRepository;
import com.vehicle.insurance.management.system.repository.UserRepository;
import com.vehicle.insurance.management.system.service.EmailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Map;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@SessionAttributes("systemOtp")
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserOTPRepository userOtpRepository;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody Map<String, String> request, HttpSession session) {
        String to = request.get("to");
        String subject = request.get("subject");
        String SystemOTP=generateOTP();
        String body ="YOUR OTP PASSWORD IS "+ SystemOTP;




        try {
            if (userRepository.existsByEmail(to)) {
                emailService.sendEmail(to, subject, body);
                UserOTP userOTP = new UserOTP();
                userOTP.setEmail(to);
                userOTP.setOtp(SystemOTP);
                userOtpRepository.save(userOTP);
                System.out.println("systemOtp set to: " + generateOTP());
                return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE)
                        .body(new MessageResponse(to));
            }
            else {
                return ResponseEntity.badRequest()
                        .body(new MessageResponse("Error: User does not exist!"));

            }
        } catch (MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Email did not send"));
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/verify")
    public ResponseEntity<?> verifyOtp(@RequestBody Map<String, String> request, HttpSession session) {
        Integer userOtp = Integer.valueOf(request.get("body"));
        UserOTP userOTP=userOtpRepository.findByEmail(request.get("to"));
        Integer SystemOTP= Integer.valueOf(userOTP.getOtp());


        System.out.println(SystemOTP+"  "+userOtp);


        if ( SystemOTP.equals(userOtp)){
            return ResponseEntity.ok(new MessageResponse("Verified successfully!"));
        }
        else {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("OTP did not Match"));
        }

    }

    public static String generateOTP() {
        // Define the length of the OTP
        int otpLength = 4;

        // Define the characters allowed in the OTP
        String allowedChars = "0123456789";

        // Create a StringBuilder to store the OTP
        StringBuilder otp = new StringBuilder(otpLength);

        // Create a Random object
        Random random = new Random();

        // Generate each digit of the OTP
        for (int i = 0; i < otpLength; i++) {
            // Get a random index from the allowedChars
            int randomIndex = random.nextInt(allowedChars.length());

            // Append the randomly selected character to the OTP
            otp.append(allowedChars.charAt(randomIndex));
        }

        // Convert the StringBuilder to a String and return
        return otp.toString();
    }
}
