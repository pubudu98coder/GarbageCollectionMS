package com.FinalYearProject.GarbageCollectionMS.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HouseHolderResponseDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String nicNo;
    private String address;
    private String email;
    private String mobileNo;
    private String houseNo;
    private boolean approved;
    private Integer garbageBinId;
    private Double longitude;
    private Double latitude;
    private String lane;
}
