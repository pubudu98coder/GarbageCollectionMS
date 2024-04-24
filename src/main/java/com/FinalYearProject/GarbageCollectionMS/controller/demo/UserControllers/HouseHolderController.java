package com.FinalYearProject.GarbageCollectionMS.controller.demo.UserControllers;

import com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.HouseOwnerComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.OccasionRequestDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.ResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.service.HouseOwnerComplaintsService;
import com.FinalYearProject.GarbageCollectionMS.service.OccasionRequestService;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/houseHolder")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials ="true",allowedHeaders = "*")
@PreAuthorize("hasAnyRole('HOUSEHOLDER')")
public class HouseHolderController {
    @Autowired
    private AuthenticationService authenticationService ;
    @Autowired
    private HouseOwnerComplaintsService houseOwnerComplaintsService;
    @Autowired
    private ResponseDTO responseDTO;
    @Autowired
    private OccasionRequestService occasionRequestService;

    @PostMapping("/houseOwnerComplaints/add")
    @PreAuthorize("hasAuthority('house_holder:create')")
    public ResponseEntity<ResponseDTO> addHouseOwnerComplaints(@RequestBody HouseOwnerComplaintsDTO houseOwnerComplaintsDTO){
        try{
            String res=houseOwnerComplaintsService.addHouseOwnerComplaints(houseOwnerComplaintsDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully saved");
                responseDTO.setContent(houseOwnerComplaintsDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            }
            else if (res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already added");
                responseDTO.setContent(houseOwnerComplaintsDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
            else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(houseOwnerComplaintsDTO);
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
    @PostMapping("/occasionRequest/add")
    @PreAuthorize("hasAuthority('house_holder:create')")
    public ResponseEntity<ResponseDTO> addOccasionRequests(@RequestBody OccasionRequestDTO occasionRequestDTO){
        try{
            String res=occasionRequestService.addOccasionRequest(occasionRequestDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully saved");
                responseDTO.setContent(occasionRequestDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            }
            else if (res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already added");
                responseDTO.setContent(occasionRequestDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
            else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(occasionRequestDTO);
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

