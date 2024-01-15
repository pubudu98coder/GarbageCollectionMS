package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
class BinRouteAssignKey implements Serializable {
    private int garbageBinID;
    private int routID;
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(this.getClass()!=o.getClass()) return false;
        BinRouteAssignKey other=(BinRouteAssignKey)o;
        return Objects.equals(this.garbageBinID,other.garbageBinID)&&Objects.equals(this.routID,other.garbageBinID);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.garbageBinID,this.routID);
    }
}
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinRouteAssign {
    @EmbeddedId
    private BinRouteAssignKey id;
    @ManyToOne
    @MapsId("garbageBinID")
    @JoinColumn
    private GarbageBin garbageBin;
    @ManyToOne
    @MapsId("routeID")
    @JoinColumn
    private Route route;
    private int index;
}
