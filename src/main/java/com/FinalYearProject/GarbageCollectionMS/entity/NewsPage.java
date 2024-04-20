package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsPage {
    @Id
    @GeneratedValue
    private int id;

    private String category;
    private String newsTitle;
    private String details;
    private String selectedImage;

}

