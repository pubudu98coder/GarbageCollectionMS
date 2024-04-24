package com.FinalYearProject.GarbageCollectionMS.Repository;

import com.FinalYearProject.GarbageCollectionMS.entity.TruckDriverComplaints;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckDriverComplaintsRepo extends JpaRepository<TruckDriverComplaints, String> {
}
