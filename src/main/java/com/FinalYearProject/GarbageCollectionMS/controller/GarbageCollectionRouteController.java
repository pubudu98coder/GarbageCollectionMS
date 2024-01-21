package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.GarabageCollectionRouteDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.VehicleDTO;
import com.FinalYearProject.GarbageCollectionMS.service.GarbageCollectionRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/route")
@CrossOrigin

public class GarbageCollectionRouteController {
    @Autowired
    private GarbageCollectionRouteService garabageCollectionRouteService;


}
