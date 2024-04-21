package com.FinalYearProject.GarbageCollectionMS.repo;

import com.FinalYearProject.GarbageCollectionMS.entity.Bin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinRepo extends JpaRepository<Bin,Integer> {
}
