package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.VehicleDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.Truck;
import com.FinalYearProject.GarbageCollectionMS.Repository.Repo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VehicleService {
    @Autowired
    private Repo vehicleRepo;
    @Autowired
    private ModelMapper modelMapper;
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO){

        vehicleRepo.save(modelMapper.map(vehicleDTO, Truck.class));
        return vehicleDTO;
    }
}
