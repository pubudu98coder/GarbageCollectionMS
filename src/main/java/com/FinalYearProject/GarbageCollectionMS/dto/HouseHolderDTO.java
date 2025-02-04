package com.FinalYearProject.GarbageCollectionMS.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HouseHolderDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String nicNo;
    private String address;
    private String email;
    private String mobileNo;
    private String lane;
    private String password;
    private Integer garbageBinId;
    private Double longitude;
    private Double latitude;
    private String houseNo;
    private boolean approved;
}
