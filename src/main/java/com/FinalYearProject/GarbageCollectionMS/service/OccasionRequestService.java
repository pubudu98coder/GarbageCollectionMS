package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.OccasionRequestDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.TruckDriverComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.OccasionRequest;
import com.FinalYearProject.GarbageCollectionMS.entity.TruckDriverComplaints;
import com.FinalYearProject.GarbageCollectionMS.repo.OccasionRequestRepo;
import com.FinalYearProject.GarbageCollectionMS.repo.TruckDriverComplaintsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccasionRequestService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OccasionRequestRepo occasionRequestRepo;

    public OccasionRequest addOccasionRequest(OccasionRequestDTO occasionRequestDTO){

        OccasionRequest occasionRequest = modelMapper.map(occasionRequestDTO,OccasionRequest.class);

        return occasionRequestRepo.save(occasionRequest);

    }
}
