package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.NewsPageDTO;
import com.FinalYearProject.GarbageCollectionMS.service.NewsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/newsPage")
@CrossOrigin


public class NewsPageController {
    @Autowired
    private NewsPageService newsPageService;



    @GetMapping(value = "/viewData")
    public List<NewsPageDTO> viewData() {

        return newsPageService.getNewsData();

    }
}
