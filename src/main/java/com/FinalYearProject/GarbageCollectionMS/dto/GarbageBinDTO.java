package com.FinalYearProject.GarbageCollectionMS.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class GarbageBinDTO {

    private double height;

    private String baseArea;

    private int numOfTargetHouses;

//    private float filledLevel;
//    private float filledWeight;
    //private String status;



}
