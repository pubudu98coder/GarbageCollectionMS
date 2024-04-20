package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.TruckDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.Truck;
import com.FinalYearProject.GarbageCollectionMS.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/auth/truck")
@CrossOrigin

public class TruckController {

    @Autowired
    private TruckService truckService;

//    @PostMapping(value = "/addTruck")
//    public Truck addTruck(@RequestBody TruckDTO truckDTO){
//
//
//        return truckService.addTruck(truckDTO);
//    }

    @GetMapping(value = "/availableTrucks")
    public List<TruckDTO> availableVehicles(){

        return truckService.availableTrucks();
    }



}
