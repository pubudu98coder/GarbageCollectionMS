package com.FinalYearProject.GarbageCollectionMS.entity;

import com.FinalYearProject.GarbageCollectionMS.util.TruckType;
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

    @Column(nullable = false,unique = true)
    private String regNumber;

    @Column(nullable = false)
    private double capacity;

    //@Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private TruckType type;
}
