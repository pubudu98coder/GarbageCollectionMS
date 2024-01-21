package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.GarabageCollectionRouteDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.VehicleDTO;
import com.FinalYearProject.GarbageCollectionMS.service.GarbageCollectionRouteService;
import com.FinalYearProject.GarbageCollectionMS.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/route")
@CrossOrigin

public class GarbageCollectionRouteController {
    @Autowired
    private GarbageCollectionRouteService garabageCollectionRouteService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/getRoute")
    public GarabageCollectionRouteDTO getRoute(){
        return garabageCollectionRouteService.Amain();
    }

    @PostMapping(value = "/saveVehicle")
    public VehicleDTO saveVehicle(@RequestBody VehicleDTO vehicleDTO) {

        return vehicleService.saveVehicle(vehicleDTO);
    }
}
