package com.vehicle.insurance.management.system.service.PersonalDetailService;

import com.vehicle.insurance.management.system.models.PersonalDetails;

import java.util.List;

public interface PersonalDetailsService {

    PersonalDetails findByCnic(String cnic);

    PersonalDetails addPersonalDetails(PersonalDetails personalDetails);

    public List<PersonalDetails> getAllPersonalDetails();

    public List<PersonalDetails> getPersonalDetailsByEmail(String email);

    // Other service methods for CRUD operations and additional functionalities

}
