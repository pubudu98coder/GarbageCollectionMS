package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class UserNotificationLog {
    @Id
    private int householderID;
    @Id
    private int notificationID;
    private LocalDateTime recieveDateTime;
}
