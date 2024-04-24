package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.TruckDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.Truck;
import com.FinalYearProject.GarbageCollectionMS.Repository.TruckRepo;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class TruckService {

    @Autowired
    private TruckRepo truckRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String addTruck(TruckDTO truckDTO){
        if(truckRepo.existsByRegNumber(truckDTO.getRegNumber())){
            return VarList.RSP_DUPLICATED;
        }
        else {
            truckRepo.save(modelMapper.map(truckDTO,Truck.class));
            return VarList.RSP_SUCCESS;
        }

//        Truck truck = new Truck();
//
//        truck.setRegNumber(truckDTO.getRegNumber());
//        truck.setCapacity(truckDTO.getCapacity());
//        truck.setStatus(truckDTO.getStatus());
//        return truckRepo.save(truck);


    }

    public List<TruckDTO> availableTrucks(){

        List<Truck> trucks = truckRepo.findByStatus("available");

        List<TruckDTO> truckDTOS = trucks.stream()
                .map(truck -> modelMapper.map(truck, TruckDTO.class))
                .collect(Collectors.toList());

        return truckDTOS;

    }




}
