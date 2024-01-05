package com.vehicle.insurance.management.system.service.DriverDetailService;

import com.vehicle.insurance.management.system.models.DriverDetails;

import java.util.List;

public interface DriverDetailsService {

    DriverDetails findByLicenseNumber(String licenseNumber);

    DriverDetails addDriverDetails(DriverDetails driverDetails);

    public List<DriverDetails> getAllDrivers();

    public List<DriverDetails> getDriverByEmail(String email);



    // Add other methods for CRUD operations and additional functionalities
}
