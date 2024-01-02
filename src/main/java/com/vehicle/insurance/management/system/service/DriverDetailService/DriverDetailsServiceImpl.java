package com.vehicle.insurance.management.system.service.DriverDetailService;

import com.vehicle.insurance.management.system.models.DriverDetails;
import com.vehicle.insurance.management.system.repository.DriverDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverDetailsServiceImpl implements DriverDetailsService {

    private final DriverDetailsRepository driverDetailsRepository;

    @Autowired
    public DriverDetailsServiceImpl(DriverDetailsRepository driverDetailsRepository) {
        this.driverDetailsRepository = driverDetailsRepository;
    }

    @Override
    public DriverDetails findByLicenseNumber(String licenseNumber) {
        return driverDetailsRepository.findByLicenseNumber(licenseNumber);
    }

    @Override
    public DriverDetails addDriverDetails(DriverDetails driverDetails) {
        return driverDetailsRepository.save(driverDetails);
    }

    // Implement other service methods for CRUD operations and additional functionalities
}
