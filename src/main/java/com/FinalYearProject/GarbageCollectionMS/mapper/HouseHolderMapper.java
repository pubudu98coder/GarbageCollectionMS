package com.FinalYearProject.GarbageCollectionMS.mapper;

import com.FinalYearProject.GarbageCollectionMS.dto.HouseHolderDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.HouseHolderResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.users.HouseHolder;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.config.Role;
import org.springframework.stereotype.Service;

@Service
public class HouseHolderMapper {
    public HouseHolderResponseDTO toHouseHolderResponseDTO(HouseHolder houseHolder){
        HouseHolderResponseDTO houseHolderResponseDTO =  HouseHolderResponseDTO.builder()
                .id(houseHolder.getId())
                .firstName(houseHolder.getFirstName())
                .lastName(houseHolder.getLastName())
                .nicNo(houseHolder.getNicNo())
                .address(houseHolder.getAddress())
                .email(houseHolder.getEmail())
                .mobileNo(houseHolder.getMobileNo())
                .houseNo(houseHolder.getHouseNo())
                .approved(houseHolder.isApproved())
                .longitude(houseHolder.getLongitude())
                .latitude(houseHolder.getLatitude())
                .lane(houseHolder.getLane())
                .build();

                if  (houseHolder.getGarbageBin()!= null) {
                    houseHolderResponseDTO.setGarbageBinId(houseHolder.getGarbageBin().getId());
                    return houseHolderResponseDTO;
                } else {
                    return houseHolderResponseDTO;
                }
    }

    public HouseHolder toHouseHolder(HouseHolderDTO houseHolderDTO){
        return HouseHolder.builder()
                .firstName(houseHolderDTO.getFirstName())
                .lastName(houseHolderDTO.getLastName())
                .nicNo(houseHolderDTO.getNicNo())
                .address(houseHolderDTO.getAddress())
                .email(houseHolderDTO.getEmail())
                .mobileNo(houseHolderDTO.getMobileNo())
                .password(houseHolderDTO.getPassword())
                .role(Role.HOUSEHOLDER)
                .longitude(houseHolderDTO.getLongitude())
                .latitude(houseHolderDTO.getLatitude())
                .houseNo(houseHolderDTO.getHouseNo())
                .approved(houseHolderDTO.isApproved())
                .lane(houseHolderDTO.getLane())
                .build();
    }
}
