package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OccasionRequest {

    @Id
    @GeneratedValue
    private int id;
    private String occasionType;
    private Date date;
    private String contactNumber;
    private  String description;
}
