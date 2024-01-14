package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class FillLevel {
    @Id
    private int garbageBinID;
    private LocalDate date;//[TODO]:primary key need to be completed
    private float fillLevel;
}
