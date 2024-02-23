package com.FinalYearProject.GarbageCollectionMS.entity;

import com.FinalYearProject.GarbageCollectionMS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
