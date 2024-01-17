package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class HouseHolder extends User {
    @Column(nullable = false)
    private float longitude;
    @Column(nullable = false)
    private float latitude;
    @ManyToOne
    @JoinColumn(name = "garbageBinID",referencedColumnName = "id")
    private GarbageBin garbageBin;

    @ManyToOne
    @JoinColumn(name="inquiryID",referencedColumnName = "id")
    private Inquiry inquiry;

    @OneToMany(mappedBy = "householder")
    private List<HouseHolderNotificationLog> houseHolderNotificationLogList;

}
