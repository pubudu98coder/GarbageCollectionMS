package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.DriverDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.Driver;
import com.FinalYearProject.GarbageCollectionMS.repo.DriverRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        driver.setDlNumber(addDriverDTO.getDlNumber());



        return driverRepo.save(driver);

    }
}
