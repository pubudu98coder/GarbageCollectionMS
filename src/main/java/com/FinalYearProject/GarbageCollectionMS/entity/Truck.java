package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Truck {
    @Id
    @GeneratedValue
    private int id;
    private String RegNo;
    private float capacity;
}
