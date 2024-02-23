package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Entity
//@Builder
@NonNull
@AllArgsConstructor
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(name = "driver_id")
public class Driver extends User {
    private String licence_no;

//    @OneToMany(mappedBy = "driver")
//    private List<DriverTruckLog> driverTruckLogList;
}
