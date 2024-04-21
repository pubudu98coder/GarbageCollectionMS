package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinIOTInput;
import com.FinalYearProject.GarbageCollectionMS.service.GarbageBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/garbageBin")
@CrossOrigin

public class GarbageBinController {

    @Autowired
    private GarbageBinService garbageBinService;

    @GetMapping (value = "/viewBinData")
    public List<GarbageBinDTO> viewBinData(){
        return garbageBinService.getBinData();
    }

    @GetMapping (value = "/filledBinData")
    public List<GarbageBinDTO> viewFilledBins(){
        return garbageBinService.getFilledBins();
    }

//    @GetMapping (value = "/filledBinDataByLevel")
//    public List<GarbageBinDTO> viewFilledBinsByLevel(){
//        return garbageBinService.getFilledBinsByLevel();
//    }
    //to get data from iot
    @PostMapping(value="/input/{id}")
    public void inputIOTData(@RequestBody GarbageBinIOTInput input,@PathVariable String id){
        garbageBinService.inputIOTData(id,input.getFilledHeight(),input.getLongitude(),input.getLatitude());
    }

    @GetMapping(value = "/getFilledBinIdAndVolume")
    public float[][] getData(){

        return garbageBinService.getAvailableBinsIdAndFilledVolume();

    }
}
