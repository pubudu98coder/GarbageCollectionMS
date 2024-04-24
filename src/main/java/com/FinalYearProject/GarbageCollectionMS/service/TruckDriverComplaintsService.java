package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.HouseOwnerComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.TruckDriverComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.entity.HouseOwnerComplaints;
import com.FinalYearProject.GarbageCollectionMS.entity.TruckDriverComplaints;
import com.FinalYearProject.GarbageCollectionMS.repo.HouseOwnerComplaintsRepo;
import com.FinalYearProject.GarbageCollectionMS.repo.TruckDriverComplaintsRepo;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TruckDriverComplaintsService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TruckDriverComplaintsRepo truckDriverComplaintsRepo;

    public String addTruckDriverComplaints(TruckDriverComplaintsDTO truckDriverComplaintsDTO){
        TruckDriverComplaints truckDriverComplaints = modelMapper.map(truckDriverComplaintsDTO,TruckDriverComplaints.class);

        truckDriverComplaintsRepo.save(truckDriverComplaints);
        return VarList.RSP_SUCCESS;

    }

    public List<TruckDriverComplaintsDTO> getComplaints (){
        List<TruckDriverComplaints> truckDriverComplaints = truckDriverComplaintsRepo.findAll();

        // Using Java streams to map GarbageBin entities to GarbageBinDTOs
        // garbageBins.stream() converts List<GarbageBin> garbageBins into a stream(a sequence of elements which can be processed parallel or sequentially )
        List<TruckDriverComplaintsDTO> truckDriverComplaintsDTOS = truckDriverComplaints.stream()
                .map(complaints -> modelMapper.map(complaints, TruckDriverComplaintsDTO.class))
                .collect(Collectors.toList());

        return truckDriverComplaintsDTOS;


    }
}
