package com.FinalYearProject.GarbageCollectionMS.mapper;

import com.FinalYearProject.GarbageCollectionMS.dto.Driver.DriverRegisterRequestDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Driver;
import org.springframework.stereotype.Service;

@Service
public class DriverMapper {
    public Driver toDriver(DriverRegisterRequestDTO driverRegisterRequestDTO){
        return Driver.builder()
                .firstName(driverRegisterRequestDTO.firstName())
                .lastName(driverRegisterRequestDTO.lastName())
                .nicNo(driverRegisterRequestDTO.nicNo())
                .email(driverRegisterRequestDTO.email())
                .address(driverRegisterRequestDTO.address())
                .mobileNo(driverRegisterRequestDTO.mobileNo())
                .licenceNo(driverRegisterRequestDTO.licenceNo())
                .empNumber(driverRegisterRequestDTO.empNumber())
                .build();
    }
}
