package com.FinalYearProject.GarbageCollectionMS.entity;

import com.FinalYearProject.GarbageCollectionMS.util.NotificationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class Notification {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private NotificationType type;
    private LocalDateTime createdDateTime;
}
