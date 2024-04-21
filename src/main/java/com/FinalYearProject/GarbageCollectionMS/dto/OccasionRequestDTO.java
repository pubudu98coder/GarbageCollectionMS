package com.FinalYearProject.GarbageCollectionMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OccasionRequestDTO {
    private int id;
    private String occasionType;
    private Date date;
    private String contactNumber;
    private  String description;
}
