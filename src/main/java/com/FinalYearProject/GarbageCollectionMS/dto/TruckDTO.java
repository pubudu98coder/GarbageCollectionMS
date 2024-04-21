package com.FinalYearProject.GarbageCollectionMS.dto;

import com.FinalYearProject.GarbageCollectionMS.entity.DriverTruckLog;
import com.FinalYearProject.GarbageCollectionMS.entity.Route;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data

public class TruckDTO {

    private int id;

    @Column(nullable = false)
    private String regNumber;

    @Column(nullable = false)
    private float capacity;

    @Column(nullable = false)
    private String status;

    //private List<Route> routes;

    //private List<DriverTruckLog> driverTruckLogList;

}
