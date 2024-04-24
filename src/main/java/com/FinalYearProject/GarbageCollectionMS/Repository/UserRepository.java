package com.FinalYearProject.GarbageCollectionMS.Repository;

import com.FinalYearProject.GarbageCollectionMS.securityImplentation.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByNicNo(String nic);


    boolean existsByNicNo(String nicNo);
}
