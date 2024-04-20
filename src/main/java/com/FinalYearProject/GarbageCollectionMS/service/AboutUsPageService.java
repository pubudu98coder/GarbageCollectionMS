package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.AboutUsPageDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.TruckDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.AboutUsPage;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.entity.Truck;
import com.FinalYearProject.GarbageCollectionMS.repo.AboutUsPageRepo;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutUsPageService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AboutUsPageRepo aboutUsPageRepo;

//    public AboutUsPage addAboutUsData(AboutUsPageDTO aboutUsPageDTO){
//
//        AboutUsPage aboutUsPage = modelMapper.map(aboutUsPageDTO,AboutUsPage.class);
//
//        return aboutUsPageRepo.save(aboutUsPage);
//
//    }
    public String addAboutUsData(AboutUsPageDTO aboutUsPageDTO){

        AboutUsPage aboutUsPage = modelMapper.map(aboutUsPageDTO,AboutUsPage.class);
        aboutUsPageRepo.save(aboutUsPage);
        return VarList.RSP_SUCCESS;

    }

    public List<AboutUsPageDTO> getAboutUsData(){
        List<AboutUsPage>aboutUsPages=aboutUsPageRepo.findAll();

        List<AboutUsPageDTO>aboutUsPageDTOS=aboutUsPages.stream()
                .map(aboutUsPage -> modelMapper.map(aboutUsPage, AboutUsPageDTO.class))
                .collect(Collectors.toList());

        return aboutUsPageDTOS;
    }
}