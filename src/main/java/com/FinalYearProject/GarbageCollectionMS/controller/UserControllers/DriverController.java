package com.FinalYearProject.GarbageCollectionMS.controller.UserControllers;

import com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.dto.ResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.TruckDriverComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.service.TruckDriverComplaintsService;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/driver")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials ="true",allowedHeaders = "*")
@PreAuthorize("hasAnyRole('DRIVER')")
public class DriverController {
    @Autowired
    private ResponseDTO responseDTO;

    @Autowired
    private TruckDriverComplaintsService truckDriverComplaintsService;
    @Autowired
    private AuthenticationService authenticationService ;

    @PostMapping("/truckDriverComplaints/add")
    @PreAuthorize("hasAuthority('truck_driver:create')")
    public ResponseEntity<ResponseDTO> addTruckDriverComplaints(@RequestBody TruckDriverComplaintsDTO truckDriverComplaintsDTO){
        try{
            String res=truckDriverComplaintsService.addTruckDriverComplaints(truckDriverComplaintsDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully saved");
                responseDTO.setContent(truckDriverComplaintsDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            }
            else if (res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already added");
                responseDTO.setContent(truckDriverComplaintsDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
            else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(truckDriverComplaintsDTO);
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
}
