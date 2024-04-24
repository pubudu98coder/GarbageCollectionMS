package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.Repository.GarbageBinRepo;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GarbageBinService {

    @Autowired
    private GarbageBinRepo garbageBinRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<GarbageBinDTO> getBinData (){
        List<GarbageBin> garbageBins = garbageBinRepo.findAll();

        // Using Java streams to map GarbageBin entities to GarbageBinDTOs
        // garbageBins.stream() converts List<GarbageBin> garbageBins into a stream(a sequence of elements which can be processed parallel or sequentially )
        List<GarbageBinDTO> garbageBinDTOs = garbageBins.stream()
                .map(bin -> modelMapper.map(bin, GarbageBinDTO.class))
                .collect(Collectors.toList());

        return garbageBinDTOs;


    }

    public List<GarbageBinDTO> getFilledBins(){

        List<GarbageBin> garbageBins = garbageBinRepo.findByStatus("filled bin");

        List<GarbageBinDTO> garbageBinDTOs = garbageBins.stream()
                .map(bin -> modelMapper.map(bin, GarbageBinDTO.class))
                .collect(Collectors.toList());

        return garbageBinDTOs;
    }

    public List<GarbageBinDTO> getFilledBinsByLevel(){

        List<GarbageBin> garbageBins = garbageBinRepo.findByFilledLevel(8);

        List<GarbageBinDTO> garbageBinDTOs = garbageBins.stream()
                .map(bin -> modelMapper.map(bin, GarbageBinDTO.class))
                .collect(Collectors.toList());

        return garbageBinDTOs;
    }

    public float[][] getAvailableBinsIdAndFilledVolume(){

        List<String> statusList = Arrays.asList("filled bin","origin");

        List<GarbageBin> availableBins = garbageBinRepo.findByStatusIn(statusList);

        float[][] binInfoArray = new float[availableBins.size()][2];

        for (int i = 0; i < availableBins.size(); i++) {
            GarbageBin bin = availableBins.get(i);
            binInfoArray[i][0] = bin.getId(); // Store bin ID
            binInfoArray[i][1] = bin.getFilledVolume(); // Store filled volume
        }

        return binInfoArray;
    }




    public String addBinDetails(GarbageBinDTO garbageBinDTO){
        GarbageBin garbageBin=modelMapper.map(garbageBinDTO,GarbageBin.class);
        if(!garbageBinRepo.existsById(garbageBinDTO.getId())) {
            if (garbageBinDTO.getLocationType().equals("Residence")){
                garbageBin.setNumOfHouses(garbageBinDTO.getNumOfHouses());
            }
            garbageBinRepo.save(garbageBin);
            return VarList.RSP_SUCCESS;
        }
        else
            return VarList.RSP_DUPLICATED;
    }


    //method to input iot data
    public void inputIOTData(int id,double filledHeight,double longitude,double latitude){
        GarbageBin garbageBin= garbageBinRepo.findGarbageBinById(id);
        garbageBin.setFilledLevel((float) filledHeight);
        garbageBin.setLongitude(longitude);
        garbageBin.setLatitude(latitude);

        garbageBinRepo.save(garbageBin);
    }
}
