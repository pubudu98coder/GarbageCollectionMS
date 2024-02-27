package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.AboutUsPageDTO;
import com.FinalYearProject.GarbageCollectionMS.service.AboutUsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/AboutUsPage")
@CrossOrigin


public class AboutUsPageController {
    @Autowired
    private AboutUsPageService aboutUsPageService;

    @GetMapping(value = "/viewAboutUsData")
    public List<AboutUsPageDTO> viewAboutUsData(){
        return aboutUsPageService.getAboutUsData();
    }
}
