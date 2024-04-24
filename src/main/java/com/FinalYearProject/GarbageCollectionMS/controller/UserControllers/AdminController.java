package com.FinalYearProject.GarbageCollectionMS.controller.UserControllers;

import com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.dto.*;
import com.FinalYearProject.GarbageCollectionMS.service.*;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/admin")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials ="true",allowedHeaders = "*")
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminController {
    @Autowired
    private GarbageBinService garbageBinService;

    @Autowired
    private AuthenticationService authenticationService ;
    @Autowired
    private ResponseDTO responseDTO;
    @Autowired
    private HouseHolderService houseHolderService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private TruckService truckService;
    @Autowired
    private NewsPageService newsPageService;
    @Autowired
    private AboutUsPageService aboutUsPageService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public String get(){
        return "GET::admin controller";
    }

    @PostMapping("/garbageBin/add")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<ResponseDTO> addGarbageBin(@RequestBody GarbageBinDTO garbageBinDTO){

        //return ResponseEntity.ok(garbageBinService.addBinDetails(garbageBinDTO));
        //"POST::admin controller";
        try{
            String res=garbageBinService.addBinDetails(garbageBinDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Succesfully saved");
                responseDTO.setContent(garbageBinDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            }
            else if (res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Allready added");
                responseDTO.setContent(garbageBinDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
            else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(garbageBinDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);//need to add appropriate status code
            }
        }
        catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    public String put(){
        return "PUT::admin controller";
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete')")
    public String delete(){
        return "DELETE::admin controller";
    }

    @PostMapping(value="/registerAdmin")
    @PreAuthorize("hasAnyAuthority('admin:create')")
    public ResponseEntity<ResponseDTO> registerAdmin(@RequestBody AdminDTO adminDTO){
        try{
            String res=adminService.registerAdmin(adminDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Succesfully saved");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            }
            else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Allready added");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ALREADY_REPORTED);
            }
            else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Driver
    @PostMapping(value="/registerDriver")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<ResponseDTO> registerDriver(@RequestBody DriverDTO driverDTO){
        try{
            String res=driverService.registerDriver(driverDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Succesfully saved");
                responseDTO.setContent(driverDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            }
            else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Allready added");
                responseDTO.setContent(driverDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ALREADY_REPORTED);
            }
            else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(driverDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
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
                responseDTO.setMessage("Succesfully saved");
                responseDTO.setContent(truckDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            }
            else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Allready added");
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
                responseDTO.setMessage("Succesfully saved");
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
                responseDTO.setMessage("Succesfully saved");
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


}
