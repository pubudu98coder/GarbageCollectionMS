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
    private String regNumber;

    private float capacity;

    private String status;

    private TruckType type;

//    private List<Route> routes;
//
//    private List<DriverTruckLog> driverTruckLogList;

}
