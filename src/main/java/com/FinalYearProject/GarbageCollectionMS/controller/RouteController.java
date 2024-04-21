package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.service.VehicleSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/api/v1/route")
public class RouteController {

    private final VehicleSelector vehicleSelector;

    @Autowired
    public RouteController(VehicleSelector vehicleSelector) {
        this.vehicleSelector = vehicleSelector;
    }

    @GetMapping("/routefinder")
    public void getRoute() throws ParseException {
        try {
            vehicleSelector.routeFinder();
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
