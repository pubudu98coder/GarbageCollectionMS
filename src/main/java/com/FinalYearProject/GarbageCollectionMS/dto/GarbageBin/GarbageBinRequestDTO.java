package com.FinalYearProject.GarbageCollectionMS.dto.GarbageBin;

import org.jetbrains.annotations.NotNull;

public record GarbageBinRequestDTO(
        @NotNull("GarbageBin ID is required")
        Integer id,
        @NotNull("Longitude is required")
        Double longitude,
        @NotNull("Latitude is required")
        Double latitude,
        @NotNull("Height is required")
        Double height,
        @NotNull("BaseArea is required")
        Double baseArea,
        @NotNull("Lane is Required")
        String lane,
        @NotNull("Number of houses is required")
        Integer numOfHouses
) {
}
