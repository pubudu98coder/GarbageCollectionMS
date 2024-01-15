package com.FinalYearProject.GarbageCollectionMS.entity;

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
public class Inquiry {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    private LocalDateTime createdDateTime;
    @OneToMany(mappedBy = "inquiry")
    private List<HouseHolder> houseHolders;
}
