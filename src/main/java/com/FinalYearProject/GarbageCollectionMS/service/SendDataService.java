package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.BinDataDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.Repository.GarbageBinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendDataService {

    @Autowired
    private GarbageBinRepository garbageBinRepository;

    public void saveDataToBin(BinDataDTO binDataDTO){

        //GarbageBin garbageBin = parseData(binDataDTO);
        //garbageBinRepo.save(garbageBin);

        GarbageBin garbageBin = garbageBinRepository.findById(binDataDTO.getId()).orElse(null);

        if (garbageBin != null) {
            // Update the relevant fields with the new data
            garbageBin.setLatitude(binDataDTO.getLatitude());
            garbageBin.setLongitude(binDataDTO.getLongitude());
            garbageBin.setFilledLevel(binDataDTO.getFilledLevel());
            //garbageBin.setFilledVolume(binDataDTO.getFilledVolume());
            garbageBin.setFilledVolume(garbageBin.getBaseArea()* binDataDTO.getFilledLevel());
            double percentage=(binDataDTO.getFilledLevel()/garbageBin.getHeight())*100;
            garbageBin.setPercentage(percentage);

            if(percentage>50){
              garbageBin.setFilled(true);
            }
            //garbageBin.setStatus(binDataDTO.getStatus());

            // Save the updated entity back to the repository
            garbageBinRepository.save(garbageBin);
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
