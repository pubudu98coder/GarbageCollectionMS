package com.FinalYearProject.GarbageCollectionMS.Repository;

import com.FinalYearProject.GarbageCollectionMS.entity.users.Visible.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
