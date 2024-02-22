package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.TruckDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.entity.Truck;
import com.FinalYearProject.GarbageCollectionMS.repo.TruckRepo;
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

    public Truck addTruck(TruckDTO truckDTO){

        Truck truck = new Truck();

        truck.setRegNumber(truckDTO.getRegNumber());
        truck.setCapacity(truckDTO.getCapacity());
        truck.setStatus(truckDTO.getStatus());

        return truckRepo.save(truck);

    }

    public List<TruckDTO> availableTrucks(){

        List<Truck> trucks = truckRepo.findByStatus("available");

        List<TruckDTO> truckDTOS = trucks.stream()
                .map(truck -> modelMapper.map(truck, TruckDTO.class))
                .collect(Collectors.toList());

        return truckDTOS;

    }




}
