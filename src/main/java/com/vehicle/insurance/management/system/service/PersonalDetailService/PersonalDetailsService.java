package com.vehicle.insurance.management.system.service.PersonalDetailService;

import com.vehicle.insurance.management.system.models.PersonalDetails;

public interface PersonalDetailsService {

    PersonalDetails findByCnic(String cnic);

    PersonalDetails addPersonalDetails(PersonalDetails personalDetails);

    // Other service methods for CRUD operations and additional functionalities

}
