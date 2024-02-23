package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarbageBin {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private float longitude;

    @Column(nullable = false)
    private float latitude;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garbageBin",fetch = FetchType.EAGER)
//    private List<HouseHolder> houseHolders;

    @OneToMany(mappedBy = "garbageBin")
    private List<GarbageBinRouteAssign> garbageBinRouteAssignList;

    private float filledLevel;
    private float filledWeight;
    private String status;
}