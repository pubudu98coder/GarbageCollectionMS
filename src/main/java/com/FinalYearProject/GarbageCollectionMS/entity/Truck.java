package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Truck {
    @Id
    @GeneratedValue
    private int id;
    private String RegNo;
    private float capacity;
    @OneToMany(mappedBy = "truck")
    private List<Route> routes;

    @OneToMany(mappedBy = "truck")
    private List<DriverTruckLog> driverTruckLogList;
}
