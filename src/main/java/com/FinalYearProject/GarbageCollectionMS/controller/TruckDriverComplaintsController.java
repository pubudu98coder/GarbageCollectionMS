package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.HouseOwnerComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.TruckDriverComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.HouseOwnerComplaints;
import com.FinalYearProject.GarbageCollectionMS.entity.TruckDriverComplaints;
import com.FinalYearProject.GarbageCollectionMS.service.HouseOwnerComplaintsService;
import com.FinalYearProject.GarbageCollectionMS.service.TruckDriverComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/auth/TruckDriverComplaints")
@CrossOrigin
public class TruckDriverComplaintsController {
    @Autowired
    private TruckDriverComplaintsService truckDriverComplaintsService;

    @PostMapping(value = "/addComplaints")
    public TruckDriverComplaints addTruckDriverComplaints(@RequestBody TruckDriverComplaintsDTO addTruckDriverComplaintsDTO){

        return truckDriverComplaintsService.addTruckDriverComplaints(addTruckDriverComplaintsDTO);
    }
}
