package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
public class Route {
    @Id
    @GeneratedValue
    private int id;
    private int truckID;
    private LocalDateTime dateTime;
    private float totalVolume;
    private float totalDistance;
}
