package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends User{
    private String licenceNo;
    private String EmpNo;
    @OneToMany(mappedBy = "driver")
    private List<DriverTruckLog> driverTruckLogList;
}
