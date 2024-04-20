package com.FinalYearProject.GarbageCollectionMS.controller;


import com.FinalYearProject.GarbageCollectionMS.dto.HouseOwnerComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.HouseOwnerComplaints;
import com.FinalYearProject.GarbageCollectionMS.service.HouseOwnerComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/auth/houseOwnerComplaints")
@CrossOrigin
public class HouseOwnerComplaintsController {
    @Autowired
    private HouseOwnerComplaintsService houseOwnerComplaintsService;

    @PostMapping(value = "/addComplaints")
    public HouseOwnerComplaints addHouseOwnerComplaints(@RequestBody HouseOwnerComplaintsDTO addHouseOwnerComplaintsDTO){

        return houseOwnerComplaintsService.addHouseOwnerComplaints(addHouseOwnerComplaintsDTO);
    }
}
