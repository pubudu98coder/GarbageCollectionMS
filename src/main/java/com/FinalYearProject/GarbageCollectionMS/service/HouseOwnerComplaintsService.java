package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.HouseOwnerComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.HouseOwnerComplaints;
import com.FinalYearProject.GarbageCollectionMS.repo.HouseOwnerComplaintsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseOwnerComplaintsService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private HouseOwnerComplaintsRepo houseOwnerComplaintsRepo;

    public HouseOwnerComplaints addHouseOwnerComplaints(HouseOwnerComplaintsDTO houseOwnerComplaintsDTO){

        HouseOwnerComplaints houseOwnerComplaints = modelMapper.map(houseOwnerComplaintsDTO,HouseOwnerComplaints.class);

        return houseOwnerComplaintsRepo.save(houseOwnerComplaints);

    }
}
