package com.vehicle.insurance.management.system.service.Combine;

import com.vehicle.insurance.management.system.models.CombinedDetails;
import com.vehicle.insurance.management.system.models.DriverDetails;
import com.vehicle.insurance.management.system.models.PersonalDetails;
import com.vehicle.insurance.management.system.models.VehicleDetails;
import com.vehicle.insurance.management.system.service.DriverDetailService.DriverDetailsService;
import com.vehicle.insurance.management.system.service.PersonalDetailService.PersonalDetailsService;
import com.vehicle.insurance.management.system.service.VehicleDetails.VehicleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombinedService {

    private final VehicleDetailsService vehicleDetailsService;
    private final DriverDetailsService driverDetailsService;
    private final PersonalDetailsService personalDetailsService;

    @Autowired
    public CombinedService(VehicleDetailsService vehicleDetailsService,
                           DriverDetailsService driverDetailsService,
                           PersonalDetailsService personalDetailsService) {
        this.vehicleDetailsService = vehicleDetailsService;
        this.driverDetailsService = driverDetailsService;
        this.personalDetailsService = personalDetailsService;
    }

    public CombinedDetails getCombinedDetailsByEmail(String email) {
        List<VehicleDetails> vehicles = vehicleDetailsService.getVehiclesByEmail(email);
        List<DriverDetails> drivers = driverDetailsService.getDriverByEmail(email);
        List<PersonalDetails> personals = personalDetailsService.getPersonalDetailsByEmail(email);

        return new CombinedDetails(vehicles, drivers, personals);
    }
}
