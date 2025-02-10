package com.FinalYearProject.GarbageCollectionMS.controller.UserControllers;

import com.FinalYearProject.GarbageCollectionMS.dto.*;
import com.FinalYearProject.GarbageCollectionMS.dto.HouseHolder.HouseHolderDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.HouseHolder.HouseHolderResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.service.HouseHolderService;
import com.FinalYearProject.GarbageCollectionMS.service.HouseOwnerComplaintsService;
import com.FinalYearProject.GarbageCollectionMS.service.OccasionRequestService;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/houseHolder")
@CrossOrigin(origins = "http://localhost:3000")
@PreAuthorize("hasAnyRole('HOUSEHOLDER','ADMIN')")
public class HouseHolderController {
    private final AuthenticationService authenticationService ;
    private final HouseOwnerComplaintsService houseOwnerComplaintsService;
    private final ResponseDTO responseDTO;
    private final OccasionRequestService occasionRequestService;
    private final HouseHolderService houseHolderService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<HouseHolderResponseDTO>> getAll(){
        return ResponseEntity.ok(houseHolderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseHolderResponseDTO> getHouseHolderById(@PathVariable Integer id){
        return ResponseEntity.ok(houseHolderService.getHouseHolderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HouseHolderResponseDTO> updateById(@PathVariable Integer id, @RequestBody HouseHolderDTO houseHolderDTO){
        return ResponseEntity.ok(houseHolderService.updateById(id, houseHolderDTO));
    }

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

