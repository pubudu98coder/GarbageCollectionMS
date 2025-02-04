package com.FinalYearProject.GarbageCollectionMS.entity.users;

import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.entity.HouseHolderNotificationLog;
import com.FinalYearProject.GarbageCollectionMS.entity.Inquiry;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;



@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@SuperBuilder
@RequiredArgsConstructor
@PrimaryKeyJoinColumn//(name = "houseHolder_id")
public class HouseHolder extends User {
    //@Column(nullable = false)
    private Double longitude;
    //@Column(nullable = false)
    private Double latitude;
    private String lane;
    private String houseNo;
    private boolean approved;

    //garbageBin and HouseHolder one to many relation
    @ManyToOne
    @JoinColumn(name = "garbageBin_id",referencedColumnName = "id")
    private GarbageBin garbageBin;

    @ManyToOne
    @JoinColumn(name="inquiryId",referencedColumnName = "id")
    private Inquiry inquiry;

    @OneToMany(mappedBy = "houseHolder")
    private List<HouseHolderNotificationLog> houseHolderNotificationLogList;

    //methods
    //register


}
