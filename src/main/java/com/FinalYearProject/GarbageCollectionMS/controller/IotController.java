package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.BinDataDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.ResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.VehicleDTO;
import com.FinalYearProject.GarbageCollectionMS.service.*;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/auth/iot")
@CrossOrigin//(origins = "http://localhost:3000",allowedHeaders = "*")//,allowCredentials ="true"
public class IotController {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private TruckRouteService truckRouteService;

    @PostMapping(value = "/saveVehicle")
    public VehicleDTO saveVehicle(@RequestBody VehicleDTO vehicleDTO) {

        return vehicleService.saveVehicle(vehicleDTO);
    }

    @Autowired
    private DistanceMatrixAPI distanceMatrixAPI;

    @GetMapping(value = "/getdis")

    public long getDistance(Float originLatitude, Float originLongitude, Float destinationLatitude1, Float destinationLongitude1) throws Exception {

        return distanceMatrixAPI.getData(originLatitude, originLongitude, destinationLatitude1, destinationLongitude1);
    }


    @Autowired
    private DistanceMatrixCall distanceMatrixCall;

    @GetMapping("/getdisnew")

    public long[][] callMatrix() throws ParseException {

        return distanceMatrixCall.callMatrix();

    }

    @Autowired
    private RouteSelectorService routeSelectorService;

    @GetMapping("/route")
    public String[][] routeselect() {

        String[][] shortestPath = routeSelectorService.getShortestPath();
        return shortestPath;

    }

    @Autowired
    private SendDataService sendDataService;

    @PutMapping("/updateData")
    public ResponseEntity<String> uploadData(@RequestBody BinDataDTO binDataDTO) {

        sendDataService.saveDataToBin(binDataDTO);
        return ResponseEntity.ok("Data uploaded successfully");

    }

    @GetMapping(value = "/getRoute")
    public String[][] getRoute(){
        return truckRouteService.getRouteString();
    }

}
