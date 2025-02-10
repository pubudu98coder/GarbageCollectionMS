package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth.AuthenticationService;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.config.JwtService;
import com.FinalYearProject.GarbageCollectionMS.dao.DriverDAO;
import com.FinalYearProject.GarbageCollectionMS.dto.Driver.DriverDTO;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.User;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Driver;
import com.FinalYearProject.GarbageCollectionMS.Repository.DriverRepository;
import com.FinalYearProject.GarbageCollectionMS.Repository.UserRepository;
import com.FinalYearProject.GarbageCollectionMS.util.DriverPageDAO;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.FinalYearProject.GarbageCollectionMS.securityImplentation.config.Role.DRIVER;

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
//    public List<DriverDAO> getAvailableDrivers(int page, int size){
//        Pageable pageable= PageRequest.of(page,size);
//        int count=(int)driverRepository.count();
//        return modelMapper.map(driverRepository.findAll(pageable).getContent(),new TypeToken<List<DriverDAO>>(){}.getType());
//
//
//    }
    public DriverPageDAO getAvailableDrivers(int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        int count=(int)driverRepository.count();
        return DriverPageDAO
                .builder()
                .driverList(modelMapper.map(driverRepository.findAll(pageable).getContent(),new TypeToken<List<DriverDAO>>(){}.getType())).count(count).build();

    }


    //getting driver details without pagination
    public List<DriverDAO> getAvailableWithoutPaginationDrivers(){
//        List<DriverDAO>
        return modelMapper.map(driverRepository.findAll(),new TypeToken<List<DriverDAO>>(){}.getType());
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
