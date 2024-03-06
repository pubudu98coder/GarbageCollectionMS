package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.OccasionRequestDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.TruckDriverComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.OccasionRequest;
import com.FinalYearProject.GarbageCollectionMS.entity.TruckDriverComplaints;
import com.FinalYearProject.GarbageCollectionMS.service.OccasionRequestService;
import com.FinalYearProject.GarbageCollectionMS.service.TruckDriverComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/auth/OccasionRequest")
@CrossOrigin
public class OccasionRequestController {
    @Autowired
    private OccasionRequestService occasionRequestService;

    @PostMapping(value = "/addRequest")
    public OccasionRequest addOccasionRequest(@RequestBody OccasionRequestDTO addOccasionRequestDTO){

        return occasionRequestService.addOccasionRequest(addOccasionRequestDTO);
    }
}
