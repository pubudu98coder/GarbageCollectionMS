package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class GarbageBin {
    @Id
    @GeneratedValue
    private int id;
    private float longitude;
    private float latitude;
    private int houseHolderID;
    private float fillLevel;
}