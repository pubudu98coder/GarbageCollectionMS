package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class HouseHolder {
    private String location;
    private GarbageBin garbageBin;
}
