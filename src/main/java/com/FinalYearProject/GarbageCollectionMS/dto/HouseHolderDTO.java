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
    private String firstName;
    private String lastName;
    private String nicNo;
    private String address;
    private String email;
    private String mobileNo;
    private String houseNo;
    private String password;
}
