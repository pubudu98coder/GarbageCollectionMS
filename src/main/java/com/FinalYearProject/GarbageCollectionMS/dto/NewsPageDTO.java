package com.FinalYearProject.GarbageCollectionMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewsPageDTO {
    private int id;
    private String newsCatergory;
    private String newsTitle;
    private String newsDetails;
    private String image;
}
