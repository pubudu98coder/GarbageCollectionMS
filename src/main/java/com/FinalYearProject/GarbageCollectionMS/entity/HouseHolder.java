package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;



@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@PrimaryKeyJoinColumn//(name = "houseHolder_id")
public class HouseHolder extends User{
    //@Column(nullable = false)
    private float longitude;
    //@Column(nullable = false)
    private float latitude;
    @ManyToOne
    @JoinColumn(name = "garbageBinID",referencedColumnName = "id")
    private GarbageBin garbageBin;

    @ManyToOne
    @JoinColumn(name="inquiryID",referencedColumnName = "id")
    private Inquiry inquiry;

    @OneToMany(mappedBy = "houseHolder")
    private List<HouseHolderNotificationLog> houseHolderNotificationLogList;

}
