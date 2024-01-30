package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User {
    private String empNo;
}
