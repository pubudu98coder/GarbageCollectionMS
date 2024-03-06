package com.FinalYearProject.GarbageCollectionMS.entity.users;

import com.FinalYearProject.GarbageCollectionMS.entity.DriverTruckLog;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn//(name = "driver_id")
public class Driver extends User {
    private String licence_no;


    @Column(nullable = false)
    private String empNumber;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "driver")
    private List<DriverTruckLog> driverTruckLogList;
}
