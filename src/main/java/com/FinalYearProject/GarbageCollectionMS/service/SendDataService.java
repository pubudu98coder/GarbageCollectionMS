package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.BinDataDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.repo.GarbageBinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendDataService {

    @Autowired
    private GarbageBinRepo garbageBinRepo;

    public void saveDataToBin(BinDataDTO binDataDTO){

        //GarbageBin garbageBin = parseData(binDataDTO);
        //garbageBinRepo.save(garbageBin);

        GarbageBin garbageBin = garbageBinRepo.findById(binDataDTO.getId()).orElse(null);

        if (garbageBin != null) {
            // Update the relevant fields with the new data
            garbageBin.setLatitude(binDataDTO.getLatitude());
            garbageBin.setLongitude(binDataDTO.getLongitude());
            garbageBin.setFilledLevel(binDataDTO.getFilledLevel());
            garbageBin.setFilledVolume(binDataDTO.getFilledVolume());

            if(binDataDTO.getFilledLevel()>5){

              garbageBin.setStatus("filled bin");
            }
            //garbageBin.setStatus(binDataDTO.getStatus());

            // Save the updated entity back to the repository
            garbageBinRepo.save(garbageBin);
        } else {
            // Handle the case when the entity is not found
            // For example, you can throw an exception or log a message
            System.out.println("Garbage bin not found with ID: " + binDataDTO.getId());
        }

    }
    /*private GarbageBin parseData(BinDataDTO binDataDTO){

        GarbageBin garbageBin = new GarbageBin();
        garbageBin.setLatitude(binDataDTO.getLatitude());
        garbageBin.setLongitude(binDataDTO.getLongitude());
        garbageBin.setFilledLevel(binDataDTO.getFilledLevel());
        garbageBin.setFilledWeight(binDataDTO.getFilledWeight());
        garbageBin.setStatus(binDataDTO.getStatus());

        return garbageBin;

    }*/

}
