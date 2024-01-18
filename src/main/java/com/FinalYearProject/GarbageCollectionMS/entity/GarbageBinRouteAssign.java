package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
class GarbageBinRouteAssignKey implements Serializable {
    private int garbageBinID;
    private int routeID;
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(this.getClass()!=o.getClass()) return false;
        GarbageBinRouteAssignKey other=(GarbageBinRouteAssignKey)o;
        return Objects.equals(this.garbageBinID,other.garbageBinID)&&Objects.equals(this.routeID,other.routeID);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.garbageBinID,this.routeID);
    }
}
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarbageBinRouteAssign {
    @EmbeddedId
    private GarbageBinRouteAssignKey id;

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
