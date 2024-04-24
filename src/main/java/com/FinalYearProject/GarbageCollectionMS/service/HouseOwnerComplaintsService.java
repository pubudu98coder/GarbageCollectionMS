package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.HouseOwnerComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.HouseOwnerComplaints;
import com.FinalYearProject.GarbageCollectionMS.repo.HouseOwnerComplaintsRepo;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseOwnerComplaintsService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private HouseOwnerComplaintsRepo houseOwnerComplaintsRepo;

    public String addHouseOwnerComplaints(HouseOwnerComplaintsDTO houseOwnerComplaintsDTO){
        HouseOwnerComplaints houseOwnerComplaints = modelMapper.map(houseOwnerComplaintsDTO,HouseOwnerComplaints.class);
        houseOwnerComplaintsRepo.save(houseOwnerComplaints);
        return VarList.RSP_SUCCESS;
    }
}
