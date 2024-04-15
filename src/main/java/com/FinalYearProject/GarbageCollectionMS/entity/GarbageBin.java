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
    private String id;

    @Column(name = "height", nullable = false)
    private double height;

    @Column(name = "base_area", nullable = false)
    private String baseArea;

    @Column(name = "num_of_target_houses", nullable = false)
    private int numOfTargetHouses;

    //dynamic properties
    private String status;

    private double longitude;

    private double latitude;

    private double filledHeight;

    //mappings
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garbageBin",fetch = FetchType.EAGER)
    private List<HouseHolder> houseHolders;

    @OneToMany(mappedBy = "garbageBin")
    private List<GarbageBinRouteAssign> garbageBinRouteAssignList;
}