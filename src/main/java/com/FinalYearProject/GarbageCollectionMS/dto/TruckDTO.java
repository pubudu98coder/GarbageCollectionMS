package com.FinalYearProject.GarbageCollectionMS.dto;

import com.FinalYearProject.GarbageCollectionMS.entity.DriverTruckLog;
import com.FinalYearProject.GarbageCollectionMS.entity.Route;
import com.FinalYearProject.GarbageCollectionMS.util.TruckType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data

public class TruckDTO {

    private int id;

    private String regNumber;

    private float capacity;

    private String status;

    //private List<Route> routes;
    private TruckType type;

    //private List<DriverTruckLog> driverTruckLogList;

}
