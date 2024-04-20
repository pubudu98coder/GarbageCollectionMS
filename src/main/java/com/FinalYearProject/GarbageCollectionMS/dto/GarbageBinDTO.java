package com.FinalYearProject.GarbageCollectionMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class GarbageBinDTO {
    private String id;

    private String locationType;

    private String lineAddress;

    private String city;

    private String typeOfWaste;

    private int numOfHouses;

//    private float filledLevel;
//    private float filledWeight;
    //private String status;



}
