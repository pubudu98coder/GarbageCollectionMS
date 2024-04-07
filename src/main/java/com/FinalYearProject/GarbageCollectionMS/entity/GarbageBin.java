package com.FinalYearProject.GarbageCollectionMS.entity;

import com.FinalYearProject.GarbageCollectionMS.entity.users.Visible.HouseHolder;
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

    @Column(name = "height", nullable = false)
    private double height;

    @Column(name = "base_area", nullable = false)
    private String baseArea;

    @Column(name = "num_of_target_houses", nullable = false)
    private int numOfTargetHouses;

    //@Column(nullable = false)
    //private float longitude;
//
//    @Column(nullable = false)
//    private float latitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garbageBin",fetch = FetchType.EAGER)
    private List<HouseHolder> houseHolders;

    @OneToMany(mappedBy = "garbageBin")
    private List<GarbageBinRouteAssign> garbageBinRouteAssignList;

    private float filledLevel;
    private float filledWeight;
    private String status;
}