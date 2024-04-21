package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Bin {

    @Id
    @GeneratedValue
    private int binID;

    private float binLon;
    private float binLat;
}
