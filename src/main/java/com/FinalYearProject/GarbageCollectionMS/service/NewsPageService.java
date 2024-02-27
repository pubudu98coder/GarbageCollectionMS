package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.NewsPageDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.NewsPage;
import com.FinalYearProject.GarbageCollectionMS.repo.NewsPageRepo;
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

    public List<NewsPageDTO> getNewsData(){
        List<NewsPage>newsPages=newsPageRepo.findAll();

        List<NewsPageDTO>newsPageDTOS=newsPages.stream()
                .map(newsPage -> modelMapper.map(newsPage,NewsPageDTO.class))
                .collect(Collectors.toList());

        return newsPageDTOS;
    }
}
