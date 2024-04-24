package com.FinalYearProject.GarbageCollectionMS.Repository;

import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
@Repository
public interface GarbageBinRepo extends JpaRepository<GarbageBin,Integer> {

    List<GarbageBin> findByStatus(String status);
    List<GarbageBin> findByFilledLevel(float filled_level);

    @Query("SELECT gb FROM GarbageBin gb WHERE gb.status IN :statuses")
    List<GarbageBin> findByStatusIn(List<String> statuses);
    //List<GarbageBin> findByFilledLevel(float filled_level);

    GarbageBin findGarbageBinById(int id);


    //boolean existsById(String id);
}
