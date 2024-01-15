package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
class DriverTruckLogKey implements Serializable {
    private int driverID;
    private int truckID;
    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if(this.getClass()!=o.getClass()) return false;
        DriverTruckLogKey other= (DriverTruckLogKey)o;
        return Objects.equals(this.driverID,other.driverID)&&Objects.equals(this.truckID,other.truckID);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.driverID,this.truckID);
    }
}
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverTruckLog {
    @EmbeddedId
    private DriverTruckLogKey id;
    @ManyToOne
    @MapsId("driverID")
    @JoinColumn
    private Driver driver;

    @ManyToOne
    @MapsId("truckID")
    @JoinColumn
    private Truck truck;
    private LocalDate assignedDate;
}
