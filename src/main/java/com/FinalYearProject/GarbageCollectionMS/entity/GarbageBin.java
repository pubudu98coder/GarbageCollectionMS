package com.FinalYearProject.GarbageCollectionMS.entity;

import com.FinalYearProject.GarbageCollectionMS.entity.users.HouseHolder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GarbageBin {
    @Id
    @Column(unique = true)
    private Integer id;

    @NotNull("Longitude is required")
    private Double longitude;

    @NotNull("Longitude is required")
    private Double latitude;

    private String lane;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double baseArea;

    @Column( nullable = false)
    private Integer numOfHouses;

    //updating after initializing
    private double filledLevel;
    private double filledVolume;
    private String status;
    private double percentage;
    private boolean filled;

    //garbageBin and HouseHolder one to many relation
    @OneToMany(mappedBy = "garbageBin")
    private List<HouseHolder> houseHolders;

    @OneToMany(mappedBy = "garbageBin")
    private List<GarbageBinRouteAssign> garbageBinRouteAssignList;
}