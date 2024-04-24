package com.FinalYearProject.GarbageCollectionMS.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private String date;

    private String contactNumber;
    private  String description;
}
