package com.vehicle.insurance.management.system.service.DriverDetailService;

import com.vehicle.insurance.management.system.models.DriverDetails;

public interface DriverDetailsService {

    DriverDetails findByLicenseNumber(String licenseNumber);

    DriverDetails addDriverDetails(DriverDetails driverDetails);

    // Add other methods for CRUD operations and additional functionalities
}
