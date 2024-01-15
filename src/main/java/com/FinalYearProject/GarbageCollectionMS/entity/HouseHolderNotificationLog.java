package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

class HouseHolderNotificationLogKey {
    private int householderID;
    private int notificationID;

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(this.getClass()!=o.getClass()) return false;
        HouseHolderNotificationLogKey other=(HouseHolderNotificationLogKey)o;
        return Objects.equals(this.householderID,other.householderID)&&Objects.equals(this.notificationID,other.notificationID);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.householderID,this.notificationID);
    }
}
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseHolderNotificationLog {
    @EmbeddedId
    private LocalDateTime recieveDateTime;
    @ManyToOne
    @MapsId("houseHolderID")
    @JoinColumn
    private HouseHolder houseHolder;

    @ManyToOne
    @MapsId("notificationID")
    @JoinColumn
    private Notification notification;
}
