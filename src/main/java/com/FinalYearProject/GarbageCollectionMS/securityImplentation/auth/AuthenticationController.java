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
    private final ResponseDTO responseDTO;
    private final HouseHolderService houseHolderService;
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
    public ResponseEntity<AuthenticationResponse> registerHouseholder(@RequestBody HouseHolderDTO houseHolderDTO){
        return ResponseEntity.ok(houseHolderService.addHouseHolder(houseHolderDTO));
    }
}
