package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.repo.GarbageBinRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GarbageBinService {

    @Autowired
    private GarbageBinRepo garbageBinRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<GarbageBinDTO> getBinData (){
        List<GarbageBin> garbageBins = garbageBinRepo.findAll();

        // Using Java streams to map GarbageBin entities to GarbageBinDTOs
        // garbageBins.stream() converts List<GarbageBin> garbageBins into a stream(a sequence of elements which can be processed parallel or sequentially )
        List<GarbageBinDTO> garbageBinDTOs = garbageBins.stream()
                .map(bin -> modelMapper.map(bin, GarbageBinDTO.class))
                .collect(Collectors.toList());

        return garbageBinDTOs;


    }

    public List<GarbageBinDTO> getFilledBins(){

        List<GarbageBin> garbageBins = garbageBinRepo.findByStatus("filled bin");

        List<GarbageBinDTO> garbageBinDTOs = garbageBins.stream()
                .map(bin -> modelMapper.map(bin, GarbageBinDTO.class))
                .collect(Collectors.toList());

        return garbageBinDTOs;
    }

    public List<GarbageBinDTO> getFilledBinsByLevel(){

        List<GarbageBin> garbageBins = garbageBinRepo.findByFilledLevel(8);

        List<GarbageBinDTO> garbageBinDTOs = garbageBins.stream()
                .map(bin -> modelMapper.map(bin, GarbageBinDTO.class))
                .collect(Collectors.toList());

        return garbageBinDTOs;
    }

}
