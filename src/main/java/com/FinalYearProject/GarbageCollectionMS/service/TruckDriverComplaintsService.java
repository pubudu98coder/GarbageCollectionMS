package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dto.TruckDriverComplaintsDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.TruckDriverComplaints;
import com.FinalYearProject.GarbageCollectionMS.Repository.TruckDriverComplaintsRepo;
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

    public TruckDriverComplaints addTruckDriverComplaints(TruckDriverComplaintsDTO truckDriverComplaintsDTO){
        TruckDriverComplaints truckDriverComplaints = modelMapper.map(truckDriverComplaintsDTO,TruckDriverComplaints.class);

        return truckDriverComplaintsRepo.save(truckDriverComplaints);

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
