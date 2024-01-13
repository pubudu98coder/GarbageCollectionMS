package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class Inquiry {
    @Id
    @GeneratedValue
    private int id;
    private int userID;
    private String description;
    private LocalDateTime createdDateTime;

}
