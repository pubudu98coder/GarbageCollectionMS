package com.FinalYearProject.GarbageCollectionMS.repo;

import com.FinalYearProject.GarbageCollectionMS.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Truck,Integer> {
}
