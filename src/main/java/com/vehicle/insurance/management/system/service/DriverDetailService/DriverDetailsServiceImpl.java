package com.vehicle.insurance.management.system.service.DriverDetailService;

import com.vehicle.insurance.management.system.models.DriverDetails;
import com.vehicle.insurance.management.system.repository.DriverDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<DriverDetails> getAllDrivers() {
        return driverDetailsRepository.findAll();
    }

    @Override
    public List<DriverDetails> getDriverByEmail(String email) {
        return driverDetailsRepository.findByEmail(email);
    }


    // Implement other service methods for CRUD operations and additional functionalities
}
