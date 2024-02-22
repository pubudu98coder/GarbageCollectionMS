package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@DiscriminatorValue("driver")
public class Driver extends User{

    @Column(nullable = false)
    private String empNumber;

    @Column(nullable = false)
    private String dlNumber;

    @OneToMany(mappedBy = "driver")
    private List<DriverTruckLog> driverTruckLogList;
}
