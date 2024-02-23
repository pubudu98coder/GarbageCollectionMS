package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.DriverDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.Driver;
import com.FinalYearProject.GarbageCollectionMS.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/driver")
@CrossOrigin

public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping(value = "/addDriver")
    public Driver addDriver(@RequestBody DriverDTO addDriverDTO){


        return driverService.addDriver(addDriverDTO);
    }
}
