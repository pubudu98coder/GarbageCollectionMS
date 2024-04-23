package com.FinalYearProject.GarbageCollectionMS.controller.demo;
import com.FinalYearProject.GarbageCollectionMS.dto.ResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.service.DriverService;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
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
