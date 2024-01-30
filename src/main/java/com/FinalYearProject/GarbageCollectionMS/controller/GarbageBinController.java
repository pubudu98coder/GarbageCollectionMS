package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
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

    @GetMapping (value = "/filledBinDataByLevel")
    public List<GarbageBinDTO> viewFilledBinsByLevel(){


        return garbageBinService.getFilledBinsByLevel();
    }
}
