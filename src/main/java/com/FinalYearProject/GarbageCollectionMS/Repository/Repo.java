package com.FinalYearProject.GarbageCollectionMS.Repository;

import com.FinalYearProject.GarbageCollectionMS.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Truck,Integer> {
}
