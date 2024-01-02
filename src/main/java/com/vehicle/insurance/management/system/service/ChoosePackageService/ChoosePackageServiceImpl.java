package com.vehicle.insurance.management.system.service.ChoosePackageService;

import com.vehicle.insurance.management.system.models.ChoosePackage;
import com.vehicle.insurance.management.system.repository.ChoosePackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoosePackageServiceImpl implements ChoosePackageService {

    private final ChoosePackageRepository choosePackageRepository;

    @Autowired
    public ChoosePackageServiceImpl(ChoosePackageRepository choosePackageRepository) {
        this.choosePackageRepository = choosePackageRepository;
    }

    @Override
    public ChoosePackage saveChoosePackage(ChoosePackage choosePackage) {
        return choosePackageRepository.save(choosePackage);
    }

    // Implement other service methods if needed
}
