package com.FinalYearProject.GarbageCollectionMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BinDataDTO {
    private int id;
    private Double longitude;
    private Double latitude;
    private Double filledLevel;
    //private String status;
    //private float filledVolume;
}
