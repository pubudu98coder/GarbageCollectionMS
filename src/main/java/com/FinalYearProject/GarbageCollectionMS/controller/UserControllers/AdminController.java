package com.FinalYearProject.GarbageCollectionMS.controller.UserControllers;

import com.FinalYearProject.GarbageCollectionMS.dto.Driver.DriverDTO;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.dto.*;
import com.FinalYearProject.GarbageCollectionMS.service.*;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/admin")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials ="true",allowedHeaders = "*")
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminController {
    private final GarbageBinService garbageBinService;
    private final ResponseDTO responseDTO;
    private final AdminService adminService;
    private final DriverService driverService;
    private final TruckService truckService;
    private final NewsPageService newsPageService;
    private final AboutUsPageService aboutUsPageService;

    @GetMapping(value = "garbageBin/getAll")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<?> getAllGarbageBinData(){
        return new ResponseEntity<>("GET::admin controller",HttpStatus.OK);
    }


    //Driver
    //get all drivers
    @GetMapping("/getDrivers")
    @PreAuthorize("hasAnyAuthority('admin:read')")
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

    @PostMapping(value = "/truck/add")
    @PreAuthorize("hasAnyAuthority('admin:create')")
    public ResponseEntity<ResponseDTO> addTruck(@RequestBody TruckDTO truckDTO){
        try{
            String res=truckService.addTruck(truckDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully saved");
                responseDTO.setContent(truckDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            }
            else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already added");
                responseDTO.setContent(truckDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ALREADY_REPORTED);
            }
            else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(truckDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping(value = "/aboutUsPage/add")
    @PreAuthorize("hasAnyAuthority('admin:create')")
    public ResponseEntity<ResponseDTO> addAboutUsData(@RequestBody AboutUsPageDTO aboutUsPageDTO){
        try{
            String res=aboutUsPageService.addAboutUsData(aboutUsPageDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully saved");
                responseDTO.setContent(aboutUsPageDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            }
            else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(aboutUsPageDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping(value = "/newsPage/add")
    @PreAuthorize("hasAnyAuthority('admin:create')")
    public ResponseEntity<ResponseDTO> addNewsPageData(@RequestBody NewsPageDTO newsPageDTO){
        try{
            String res=newsPageService.addNewsPageData(newsPageDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully saved");
                responseDTO.setContent(newsPageDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            }
            else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(newsPageDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //get route



}
