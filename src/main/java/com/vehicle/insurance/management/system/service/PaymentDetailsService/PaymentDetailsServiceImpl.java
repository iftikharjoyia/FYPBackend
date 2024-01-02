package com.vehicle.insurance.management.system.service.PaymentDetailsService;


import com.vehicle.insurance.management.system.models.PaymentDetails;
import com.vehicle.insurance.management.system.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

    private final PaymentDetailsRepository paymentDetailsRepository;

    @Autowired
    public PaymentDetailsServiceImpl(PaymentDetailsRepository paymentDetailsRepository) {
        this.paymentDetailsRepository = paymentDetailsRepository;
    }

    @Override
    public PaymentDetails savePaymentDetails(PaymentDetails paymentDetails) {
        return paymentDetailsRepository.save(paymentDetails);
    }

    // Implement other service methods if needed
}
