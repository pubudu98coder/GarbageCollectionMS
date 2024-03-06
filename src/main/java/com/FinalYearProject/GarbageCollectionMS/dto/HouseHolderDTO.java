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
    private int id;
    private String fName;
    private String lName;
    private String userName;
    private String password;
    private String email;
    private String address;
    private float longitude;
    private float latitude;
}
