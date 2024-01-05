package com.vehicle.insurance.management.system.service.PersonalDetailService;

import com.vehicle.insurance.management.system.models.PersonalDetails;
import com.vehicle.insurance.management.system.repository.PersonalDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalDetailsServiceImpl implements PersonalDetailsService {

    private final PersonalDetailRepository personalDetailsRepository;

    @Autowired
    public PersonalDetailsServiceImpl(PersonalDetailRepository personalDetailsRepository) {
        this.personalDetailsRepository = personalDetailsRepository;
    }

    @Override
    public PersonalDetails findByCnic(String cnic) {
        return personalDetailsRepository.findByCnic(cnic);
    }

    @Override
    public PersonalDetails addPersonalDetails(PersonalDetails personalDetails) {
        return personalDetailsRepository.save(personalDetails);
    }

    @Override
    public List<PersonalDetails> getAllPersonalDetails() {
        return personalDetailsRepository.findAll();
    }

    @Override
    public List<PersonalDetails> getPersonalDetailsByEmail(String email) {
        return personalDetailsRepository.findByEmail(email);
    }


    // Implement other service methods for CRUD operations and additional functionalities

}
