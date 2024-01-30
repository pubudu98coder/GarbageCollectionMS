package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Driver extends User{

    //@Id
    //@Column(name = "driver_id")
    //private String id ;

    private String licenceNo;
    private String EmpNo;
    @OneToMany(mappedBy = "driver")
    private List<DriverTruckLog> driverTruckLogList;
}
