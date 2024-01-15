package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Route {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private LocalDateTime dateTime;
    private float totalVolume;
    private float totalDistance;
    @ManyToOne
    @JoinColumn(name="truckID",referencedColumnName = "id")
    private Truck truck;

    @OneToMany(mappedBy = "route")
    private List<BinRouteAssign> binRouteAssignList;
}
