package com.FinalYearProject.GarbageCollectionMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BinDataDTO {

    private int id;
    private float longitude;
    private float latitude;
    private float filledLevel;
    //private String status;
    private float filledVolume;
}
