package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.config.JwtService;
import com.FinalYearProject.GarbageCollectionMS.dto.DriverDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.users.User;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Visible.Driver;
import com.FinalYearProject.GarbageCollectionMS.repo.DriverRepository;
import com.FinalYearProject.GarbageCollectionMS.repo.UserRepository;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.FinalYearProject.GarbageCollectionMS.entity.users.Role.DRIVER;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverService {
    @Autowired
    private ModelMapper modelMapper;

    //registering driver
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DriverRepository driverRepository;

    public String registerDriver(DriverDTO driverDTO){
        if(userRepository.existsByNicNo(driverDTO.getNicNo())){
            return VarList.RSP_DUPLICATED;
        }
        else{
            Driver driver =modelMapper.map(driverDTO, Driver.class);
            driver.setPassword(passwordEncoder.encode(driverDTO.getPassword()));
            driver.setRole(DRIVER);
            driverRepository.save(driver);
            //
            User user=driver;
            var jwtToken=jwtService.generateToken(user);
            jwtService.generateRefreshToken(user);
            authenticationService.revokeAllUserTokens(user);
            authenticationService.saveUserToken(user,jwtToken);
            return VarList.RSP_SUCCESS;
        }
    }

    //getting driver data
//    public Page<Driver> getAvailableDrivers(int page,int size){
//        Pageable pageable= PageRequest.of(page,size);
//        return driverRepository.findAll(pageable);
//    }

    //getting driver details without pagination
    public List<Driver> getAvailableDrivers(){
        return driverRepository.findAll();
    }


//    public List<DriverDTO> availableDrivers(){
//        List<Driver> drivers = driverRepo.findByStatus("available");
//
//        List<DriverDTO> driverDTOS  = drivers.stream()
//                .map(driver -> modelMapper.map(driver, DriverDTO.class))
//                .collect(Collectors.toList());
//
//        return driverDTOS;
//  }


}
