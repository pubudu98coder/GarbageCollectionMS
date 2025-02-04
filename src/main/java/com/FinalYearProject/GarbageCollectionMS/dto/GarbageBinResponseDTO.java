package com.FinalYearProject.GarbageCollectionMS.dto;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GarbageBinResponseDTO{
    private Integer id;
    private Double longitude;
    private Double latitude;
    private String lane;
    private Double height;
    private Double baseArea;
    private Integer numOfHouses;
}
