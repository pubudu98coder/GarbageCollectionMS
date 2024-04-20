package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.dto.AboutUsPageDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.TruckDriverComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.AboutUsPage;
import com.FinalYearProject.GarbageCollectionMS.entity.TruckDriverComplaints;
import com.FinalYearProject.GarbageCollectionMS.service.AboutUsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/auth/aboutUsPage")
@CrossOrigin


public class AboutUsPageController {
    @Autowired
    private AboutUsPageService aboutUsPageService;

    @GetMapping(value = "/viewAboutUsData")
    public List<AboutUsPageDTO> viewAboutUsData(){

        return aboutUsPageService.getAboutUsData();
    }

//    @PostMapping(value = "/addAboutUsData")
//    public AboutUsPage addAboutUsPageData(@RequestBody AboutUsPageDTO addAboutUsPageDTO){
//
//        return aboutUsPageService.addAboutUsData(addAboutUsPageDTO);
//    }
}