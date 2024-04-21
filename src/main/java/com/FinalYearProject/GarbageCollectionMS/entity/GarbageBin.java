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
    @Column(unique = true)
    private int id;

    @Column(name = "location_type", nullable = false)
    private String locationType;

    @Column(name = "line_address", nullable = false)
    private String lineAddress;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "type_of_waste", nullable = false)
    private String typeOfWaste;

    @Column(name = "height", nullable = false)
    private double height;

    @Column(name = "num_of_houses", nullable = false)
    private int numOfHouses;

    @Column(name = "base_area", nullable = false)
    private String baseArea;

    private double longitude;

    private double latitude;

    //private double filledHeight;

    //mappings
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garbageBin",fetch = FetchType.EAGER)
    private List<HouseHolder> houseHolders;

    @OneToMany(mappedBy = "garbageBin")
    private List<GarbageBinRouteAssign> garbageBinRouteAssignList;

    private float filledLevel;
    private float filledVolume;
    private String status;
}