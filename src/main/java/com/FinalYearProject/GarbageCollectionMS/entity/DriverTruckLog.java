package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class DriverTruckLog {
    @Id
    private int driverID;
    @Id
    private int truckID;
    private LocalDate assignedDate;
}
