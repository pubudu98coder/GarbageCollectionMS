package com.FinalYearProject.GarbageCollectionMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseOwnerComplaintsDTO {
    private int id;
    private String complaintType;
    private String contactNo;
    private String description;
}
