package com.FinalYearProject.GarbageCollectionMS.controller.demo.UserControllers;

import com.FinalYearProject.GarbageCollectionMS.auth.AuthenticationResponse;
import com.FinalYearProject.GarbageCollectionMS.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.auth.RegisterRequest;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.ResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.service.GarbageBinService;
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
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

}
