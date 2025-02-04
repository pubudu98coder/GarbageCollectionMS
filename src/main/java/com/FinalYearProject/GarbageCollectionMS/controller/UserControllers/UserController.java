package com.FinalYearProject.GarbageCollectionMS.controller.UserControllers;
import com.FinalYearProject.GarbageCollectionMS.dto.BinDataDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.ResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.VehicleDTO;
import com.FinalYearProject.GarbageCollectionMS.service.*;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/auth/users")
@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*")//,allowCredentials ="true"
public class UserController {
    @Autowired
    private ResponseDTO responseDTO;
    @Autowired
    private DriverService driverService;
    @GetMapping
    public List<String> getUsers(){
        List<String> users= Arrays.asList("pubudu","lilanka");
        return users;
    }
    @GetMapping("/getDrivers")
//    @PreAuthorize("hasAnyAuthority('admin:read')")
    public ResponseEntity<ResponseDTO> getAllDrivers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        responseDTO.setCode(VarList.RSP_SUCCESS);
        responseDTO.setMessage("Succesfully saved");
        responseDTO.setContent(driverService.getAvailableDrivers(page,size));
        //responseDTO.setContent(driverService.getAvailableWithoutPaginationDrivers());
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }
}

//from admin-dev
//@RestController
//@RequestMapping("/api/v1/admin")
//@CrossOrigin
//
//public class AdminController_old {
//
//    @Autowired
//    private VehicleService vehicleService;
//
//    @PostMapping(value = "/saveVehicle")
//    public VehicleDTO saveVehicle(@RequestBody VehicleDTO vehicleDTO){
//
//        return vehicleService.saveVehicle(vehicleDTO);
//    }
//
//    @Autowired
//    private DistanceMatrixAPI distanceMatrixAPI;
//
//    @GetMapping(value = "/getdis")
//
//    public long getDistance(Float originLatitude, Float originLongitude, Float destinationLatitude1, Float destinationLongitude1) throws Exception {
//
//        return distanceMatrixAPI.getData(originLatitude,originLongitude,destinationLatitude1,destinationLongitude1);
//    }
//
//
//
//    @Autowired
//    private DistanceMatrixCall distanceMatrixCall;
//
//    @GetMapping("/getdisnew")
//
//    public long[][] callMatrix() throws ParseException {
//
//        return distanceMatrixCall.callMatrix();
//
//    }
//
//    @Autowired
//    private RouteSelectorService routeSelectorService;
//    @GetMapping("/route")
//    public String[][] routeselect(){
//
//        String[][] shortestPath = routeSelectorService.getShortestPath();
//        return shortestPath;
//
//    }
//
//    @Autowired
//    private SendDataService sendDataService;
//
//    @PutMapping("/updateData")
//    public ResponseEntity<String> uploadData(@RequestBody BinDataDTO binDataDTO){
//
//        sendDataService.saveDataToBin(binDataDTO);
//        return ResponseEntity.ok("Data uploaded successfully");
//
//    }
