package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.DriverDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.users.Driver;
import com.FinalYearProject.GarbageCollectionMS.repo.DriverRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Driver addDriver(DriverDTO addDriverDTO){

        Driver driver = new Driver();

        driver.setFirstName(addDriverDTO.getFirstName());
        driver.setLastName(addDriverDTO.getLastName());
        driver.setNicNumber(addDriverDTO.getNicNumber());
        driver.setAddress(addDriverDTO.getAddress());
        driver.setEmail(addDriverDTO.getEmail());
        driver.setUserName(addDriverDTO.getUserName());
        driver.setPassword(addDriverDTO.getPassword());
        driver.setEmpNumber(addDriverDTO.getEmpNumber());
        driver.setStatus(addDriverDTO.getStatus());



        return driverRepo.save(driver);

    }


    public List<DriverDTO> availableDrivers(){

        List<Driver> drivers = driverRepo.findByStatus("available");

        List<DriverDTO> driverDTOS  = drivers.stream()
                .map(driver -> modelMapper.map(driver, DriverDTO.class))
                .collect(Collectors.toList());

        return driverDTOS;

    }


}
