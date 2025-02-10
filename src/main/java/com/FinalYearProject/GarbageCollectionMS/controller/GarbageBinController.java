package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinIOTInput;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBin.GarbageBinRequestDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBin.GarbageBinResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.service.GarbageBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/garbageBin")
@CrossOrigin
@RequiredArgsConstructor
public class GarbageBinController {
    private final GarbageBinService garbageBinService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<GarbageBinResponseDTO> addGarbageBin(@RequestBody GarbageBinRequestDTO garbageBinRequestDTO ){
        return ResponseEntity.ok(garbageBinService.addGarbageBin(garbageBinRequestDTO));
    }

    @GetMapping("/getByLane/{lane}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<GarbageBinResponseDTO>> getGarbageBinByLane(@PathVariable String lane){
        return ResponseEntity.ok(garbageBinService.getGarbageBinByLane(lane));
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
    public void inputIOTData(@RequestBody GarbageBinIOTInput input,@PathVariable int id){
        garbageBinService.inputIOTData(id,input.getFilledHeight(),input.getLongitude(),input.getLatitude());
    }

    @GetMapping(value = "/getFilledBinIdAndVolume")
    public double[][] getData(){

        return garbageBinService.getAvailableBinsIdAndFilledVolume();

    }
}
