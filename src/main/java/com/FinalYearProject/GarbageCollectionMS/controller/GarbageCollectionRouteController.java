package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.GarabageCollectionRouteDTO;
import com.FinalYearProject.GarbageCollectionMS.service.GarbageCollectionRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/route")
public class GarbageCollectionRouteController {
    @Autowired
    private GarbageCollectionRouteService garabageCollectionRouteService;
    @GetMapping(value = "/getRoute")
    public GarabageCollectionRouteDTO getRoute(){
        return garabageCollectionRouteService.Amain();
    }
}
