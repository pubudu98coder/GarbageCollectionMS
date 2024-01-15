package com.FinalYearProject.GarbageCollectionMS.entity;

import com.FinalYearProject.GarbageCollectionMS.util.NotificationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private NotificationType type;
    private LocalDateTime createdDateTime;

    @OneToMany(mappedBy = "notification")
    private List<HouseHolderNotificationLog> houseHolderNotificationLogList;
}
