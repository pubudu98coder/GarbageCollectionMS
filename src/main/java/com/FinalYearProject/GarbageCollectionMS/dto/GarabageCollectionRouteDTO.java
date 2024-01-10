package com.FinalYearProject.GarbageCollectionMS.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class GarabageCollectionRouteDTO {
    private List<String> routeList;
    private List<String> routeDistanceList;
}
