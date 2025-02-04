package com.FinalYearProject.GarbageCollectionMS.mapper;

import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinRequestDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import org.springframework.stereotype.Service;

@Service
public class GarbageBinMapper {
    public GarbageBin toGarbageBin(GarbageBinRequestDTO garbageBinRequestDTO){
        return GarbageBin.builder()
                .id(garbageBinRequestDTO.id())
                .longitude(garbageBinRequestDTO.longitude())
                .latitude(garbageBinRequestDTO.latitude())
                .height(garbageBinRequestDTO.height())
                .baseArea(garbageBinRequestDTO.baseArea())
                .numOfHouses(garbageBinRequestDTO.numOfHouses())
                .build();
    }

    public GarbageBinResponseDTO toGarbageBinResponseDTO(GarbageBin garbageBin){
        return GarbageBinResponseDTO.builder()
                .id(garbageBin.getId())
                .longitude(garbageBin.getLongitude())
                .latitude(garbageBin.getLatitude())
                .lane(garbageBin.getLane())
                .height(garbageBin.getHeight())
                .baseArea(garbageBin.getBaseArea())
                .numOfHouses(garbageBin.getNumOfHouses())
                .build();
    }
}
