package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.TruckRouteDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TruckRouteService {
    @Autowired
    private RouteSelectorService routeSelectorService;
    int driverId;
    String binSet;

//    public TruckRouteDTO getRoute(){
//        String[][] shortestPath = routeSelectorService.getShortestPath();
//        int numRows = shortestPath.length;
//
//        int[] intArray = new int[shortestPath[0].length];
//
//
//        for (int i=0;i<numRows;i++){
//            driverId= Integer.parseInt(shortestPath[i][0]);
//            for (int j = 0; j < shortestPath[0].length; j++) {
//                intArray[j] = Integer.parseInt(shortestPath[i][j]); // Parse the string into an integer
//
//            }
//        }
//    }
    public String[][] getRouteString() {
        String[][] shortestPath = routeSelectorService.getShortestPath();
        return shortestPath;
    }
}
