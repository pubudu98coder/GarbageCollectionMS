package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.DriverDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Visible.Driver;
import com.FinalYearProject.GarbageCollectionMS.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/driver")
@CrossOrigin

public class DriverController {

    @Autowired
    private DriverService driverService;


//    @GetMapping(value = "/availableDrivers")
//    public List<DriverDTO> availableTrucks(){
//
//
//        return driverService.getAvailableDrivers();
//    }



}


