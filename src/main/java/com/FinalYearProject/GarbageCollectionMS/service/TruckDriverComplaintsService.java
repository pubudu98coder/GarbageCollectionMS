package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.HouseOwnerComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.TruckDriverComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.HouseOwnerComplaints;
import com.FinalYearProject.GarbageCollectionMS.entity.TruckDriverComplaints;
import com.FinalYearProject.GarbageCollectionMS.repo.HouseOwnerComplaintsRepo;
import com.FinalYearProject.GarbageCollectionMS.repo.TruckDriverComplaintsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruckDriverComplaintsService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TruckDriverComplaintsRepo truckDriverComplaintsRepo;

    public TruckDriverComplaints addTruckDriverComplaints(TruckDriverComplaintsDTO truckDriverComplaintsDTO){

        TruckDriverComplaints truckDriverComplaints = modelMapper.map(truckDriverComplaintsDTO,TruckDriverComplaints.class);

        return truckDriverComplaintsRepo.save(truckDriverComplaints);

    }
}
