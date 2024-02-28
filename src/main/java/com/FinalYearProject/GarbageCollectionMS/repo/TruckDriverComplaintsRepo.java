package com.FinalYearProject.GarbageCollectionMS.repo;

import com.FinalYearProject.GarbageCollectionMS.entity.TruckDriverComplaints;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckDriverComplaintsRepo extends JpaRepository<TruckDriverComplaints, String> {
}
