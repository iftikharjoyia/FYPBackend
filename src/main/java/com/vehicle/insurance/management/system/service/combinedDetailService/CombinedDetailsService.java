package com.vehicle.insurance.management.system.service.combinedDetailService;

import com.vehicle.insurance.management.system.models.CombinedDetailsDTO;
import com.vehicle.insurance.management.system.models.DriverDetails;
import com.vehicle.insurance.management.system.models.PersonalDetails;
import com.vehicle.insurance.management.system.models.VehicleDetails;
import com.vehicle.insurance.management.system.service.DriverDetailService.DriverDetailsService;
import com.vehicle.insurance.management.system.service.PersonalDetailService.PersonalDetailsService;
import com.vehicle.insurance.management.system.service.VehicleDetails.VehicleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CombinedDetailsService {

    private final VehicleDetailsService vehicleDetailsService;
    private final DriverDetailsService driverDetailsService;
    private final PersonalDetailsService personalDetailsService;

    @Autowired
    public CombinedDetailsService(VehicleDetailsService vehicleDetailsService,
                                  DriverDetailsService driverDetailsService,
                                  PersonalDetailsService personalDetailsService) {
        this.vehicleDetailsService = vehicleDetailsService;
        this.driverDetailsService = driverDetailsService;
        this.personalDetailsService = personalDetailsService;
    }

    public List<CombinedDetailsDTO> getCombinedDetails() {
        List<CombinedDetailsDTO> combinedDetailsList = new ArrayList<>();

        List<VehicleDetails> vehicleDetailsList = vehicleDetailsService.getAllVehicles();
        List<DriverDetails> driverDetailsList = driverDetailsService.getAllDrivers();
        List<PersonalDetails> personalDetailsList = personalDetailsService.getAllPersonalDetails();

        // Assuming there is a common field like email for matching
        for (VehicleDetails vehicleDetails : vehicleDetailsList) {
            CombinedDetailsDTO combinedDetails = new CombinedDetailsDTO();
            combinedDetails.setEmail(vehicleDetails.getEmail());
            combinedDetails.setRegistrationNumber(vehicleDetails.getRegistrationNumber());
            combinedDetails.setColor(vehicleDetails.getColor());
            combinedDetails.setModel(vehicleDetails.getModel());
            combinedDetails.setYear(vehicleDetails.getYear());

            // Find matching driver details
            DriverDetails matchingDriver = findMatchingDriver(driverDetailsList, vehicleDetails.getEmail());
            if (matchingDriver != null) {
                combinedDetails.setLicenseNumber(matchingDriver.getLicenseNumber());
                combinedDetails.setExpiryDate(matchingDriver.getExpiryDate());
                combinedDetails.setDob(matchingDriver.getDob());
            }

            // Find matching personal details
            PersonalDetails matchingPersonal = findMatchingPersonal(personalDetailsList, vehicleDetails.getEmail());
            if (matchingPersonal != null) {
                combinedDetails.setCnic(matchingPersonal.getCnic());
                combinedDetails.setName(matchingPersonal.getName());
            }

            combinedDetailsList.add(combinedDetails);
        }

        return combinedDetailsList;
    }


    public List<CombinedDetailsDTO> getCombinedDetailsByEmail(String email) {
        List<CombinedDetailsDTO> combinedDetailsList = new ArrayList<>();

        List<VehicleDetails> vehicleDetailsList = vehicleDetailsService.getVehiclesByEmail(email);
        for (VehicleDetails vehicleDetails : vehicleDetailsList) {
            CombinedDetailsDTO combinedDetails = new CombinedDetailsDTO();
            combinedDetails.setEmail(vehicleDetails.getEmail());
            combinedDetails.setRegistrationNumber(vehicleDetails.getRegistrationNumber());
            combinedDetails.setColor(vehicleDetails.getColor());
            combinedDetails.setModel(vehicleDetails.getModel());
            combinedDetails.setYear(vehicleDetails.getYear());

            // Find matching driver details
            List<DriverDetails> matchingDrivers = driverDetailsService.getDriverByEmail(email);
            if (!matchingDrivers.isEmpty()) {
                DriverDetails matchingDriver = matchingDrivers.get(0); // Assuming there is only one matching driver
                combinedDetails.setLicenseNumber(matchingDriver.getLicenseNumber());
                combinedDetails.setExpiryDate(matchingDriver.getExpiryDate());
                combinedDetails.setDob(matchingDriver.getDob());
            }

            // Find matching personal details
            List<PersonalDetails> matchingPersonals = personalDetailsService.getPersonalDetailsByEmail(email);
            if (!matchingPersonals.isEmpty()) {
                PersonalDetails matchingPersonal = matchingPersonals.get(0); // Assuming there is only one matching personal
                combinedDetails.setCnic(matchingPersonal.getCnic());
                combinedDetails.setName(matchingPersonal.getName());
            }

            combinedDetailsList.add(combinedDetails);
        }

        return combinedDetailsList;
    }



    private DriverDetails findMatchingDriver(List<DriverDetails> driverDetailsList, String email) {
        return driverDetailsList.stream()
                .filter(driverDetails -> email.equals(driverDetails.getEmail()))
                .findFirst()
                .orElse(null);
    }

    private PersonalDetails findMatchingPersonal(List<PersonalDetails> personalDetailsList, String email) {
        return personalDetailsList.stream()
                .filter(personalDetails -> email.equals(personalDetails.getEmail()))
                .findFirst()
                .orElse(null);
    }
}
