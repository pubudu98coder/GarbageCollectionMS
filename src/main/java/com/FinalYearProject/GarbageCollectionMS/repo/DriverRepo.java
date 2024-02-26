package com.FinalYearProject.GarbageCollectionMS.repo;

import com.FinalYearProject.GarbageCollectionMS.entity.users.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,Integer> {

    List<Driver> findByStatus(String status);
}
