package com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth;

import com.FinalYearProject.GarbageCollectionMS.dto.HouseHolderDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.ResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.service.HouseHolderService;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value ="/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000",allowCredentials ="true",allowedHeaders = "*")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @Autowired
    private ResponseDTO responseDTO;
    @Autowired
    HouseHolderService houseHolderService;
    @PostMapping(value = "/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest requestR){
        return  ResponseEntity.ok(authenticationService.register(requestR));
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest requestA){
        return  ResponseEntity.ok(authenticationService.authenticate(requestA));
    }

    @PostMapping(value = "/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authenticationService.refreshToken(request,response);
    }
    @PostMapping(value="/registerHouseholder")
    public ResponseEntity<ResponseDTO> registerHouseholder(@RequestBody HouseHolderDTO houseHolderDTO){
       try{
            String res=houseHolderService.addHouseHolder(houseHolderDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Succesfully saved");
                responseDTO.setContent(houseHolderDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            }
            else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Allready added");
                responseDTO.setContent(houseHolderDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ALREADY_REPORTED);
            }
            else {
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage("Error");
                responseDTO.setContent(houseHolderDTO);
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
