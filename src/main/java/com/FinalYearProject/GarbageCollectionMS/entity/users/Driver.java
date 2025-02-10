package com.FinalYearProject.GarbageCollectionMS.entity.users;

import com.FinalYearProject.GarbageCollectionMS.entity.DriverTruckLog;
import com.FinalYearProject.GarbageCollectionMS.securityImplentation.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@PrimaryKeyJoinColumn//(name = "driver_id")
public class Driver extends User {
    private String licenceNo;
    //@Column(nullable = false)
    private String empNumber;

    private boolean available;

    @OneToMany(mappedBy = "driver")
    private List<DriverTruckLog> driverTruckLogList;
}
