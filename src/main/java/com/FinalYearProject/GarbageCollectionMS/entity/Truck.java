package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor



public class Truck {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String regNumber;

    @Column(nullable = false)
    private float capacity;

    @Column(nullable = false)
    private String status;


}
