package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.NewsPageDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.NewsPage;
import com.FinalYearProject.GarbageCollectionMS.repo.NewsPageRepo;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class NewsPageService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NewsPageRepo newsPageRepo;

    public String addNewsPageData(NewsPageDTO newsPageDTO){
        NewsPage newsPage = modelMapper.map(newsPageDTO,NewsPage.class);
        newsPageRepo.save(newsPage);
        return VarList.RSP_SUCCESS;
    }

    public List<NewsPageDTO> getNewsData(){
        List<NewsPage>newsPages=newsPageRepo.findAll();

        List<NewsPageDTO>newsPageDTOS=newsPages.stream()
                .map(newsPage -> modelMapper.map(newsPage,NewsPageDTO.class))
                .collect(Collectors.toList());

        return newsPageDTOS;
    }
}
