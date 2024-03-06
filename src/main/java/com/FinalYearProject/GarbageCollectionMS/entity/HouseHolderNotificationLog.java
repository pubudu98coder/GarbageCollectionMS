package com.FinalYearProject.GarbageCollectionMS.entity;

import com.FinalYearProject.GarbageCollectionMS.entity.users.HouseHolder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
@Embeddable
class HouseHolderNotificationLogKey implements Serializable {
    private int houseHolderID;
    private int notificationID;

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(this.getClass()!=o.getClass()) return false;
        HouseHolderNotificationLogKey other=(HouseHolderNotificationLogKey)o;
        return Objects.equals(this.houseHolderID,other.houseHolderID)&&Objects.equals(this.notificationID,other.notificationID);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.houseHolderID,this.notificationID);
    }
}
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseHolderNotificationLog {
    @EmbeddedId
    private HouseHolderNotificationLogKey houseHolderNotificationLogKey;
    private LocalDateTime recieveDateTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("houseHolderID")
    @JoinColumn
    private HouseHolder houseHolder;

    @ManyToOne
    @MapsId("notificationID")
    @JoinColumn
    private Notification notification;
}
