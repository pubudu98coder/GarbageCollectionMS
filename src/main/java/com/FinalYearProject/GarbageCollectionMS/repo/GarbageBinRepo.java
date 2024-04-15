package com.FinalYearProject.GarbageCollectionMS.repo;

import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GarbageBinRepo extends JpaRepository<GarbageBin,Integer> {

    List<GarbageBin> findByStatus(String status);
    //List<GarbageBin> findByFilledLevel(float filled_level);

    GarbageBin findGarbageBinById(String id);
}
