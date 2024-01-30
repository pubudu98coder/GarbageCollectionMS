package com.FinalYearProject.GarbageCollectionMS.repo;

import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GarbageBinRepo extends JpaRepository<GarbageBin,Integer> {

    List<GarbageBin> findByStatus(String status);
    List<GarbageBin> findByFilledLevel(float filled_level);
}
