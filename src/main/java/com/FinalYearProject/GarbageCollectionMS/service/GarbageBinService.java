package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.dao.GarbageBinDAO;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBin.GarbageBinRequestDTO;
import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBin.GarbageBinResponseDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.Repository.GarbageBinRepository;
import com.FinalYearProject.GarbageCollectionMS.mapper.GarbageBinMapper;
import com.FinalYearProject.GarbageCollectionMS.util.VarList;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class GarbageBinService {
    private final GarbageBinRepository garbageBinRepository;
    private final ModelMapper modelMapper;
    private final GarbageBinMapper garbageBinMapper;

    public GarbageBinResponseDTO addGarbageBin(GarbageBinRequestDTO garbageBinRequestDTO) {
        if (garbageBinRepository.existsById(garbageBinRequestDTO.id())){
            throw new DataIntegrityViolationException("Garbage Bin Already exists with Provided ID");
        }
        GarbageBin garbageBin = garbageBinMapper.toGarbageBin(garbageBinRequestDTO);

        return garbageBinMapper.toGarbageBinResponseDTO(garbageBinRepository.save(garbageBin));
    }

    public List<GarbageBinResponseDTO> getGarbageBinByLane(String lane) {
        return garbageBinRepository.findGarbageBinsByLane(lane)
                .stream()
                .map(garbageBinMapper::toGarbageBinResponseDTO)
                .collect(Collectors.toList());
    }

//    public List<GarbageBinDTO> getBinData (){
//        List<GarbageBin> garbageBins = garbageBinRepo.findAll();
//
//        // Using Java streams to map GarbageBin entities to GarbageBinDTOs
//        // garbageBins.stream() converts List<GarbageBin> garbageBins into a stream(a sequence of elements which can be processed parallel or sequentially )
//        List<GarbageBinDTO> garbageBinDTOs = garbageBins.stream()
//                .map(bin -> modelMapper.map(bin, GarbageBinDTO.class))
//                .collect(Collectors.toList());
//
//        return garbageBinDTOs;
//
//
//    }

    public List<GarbageBinDTO> getFilledBins(){

        List<GarbageBin> garbageBins = garbageBinRepository.findByStatus("filled bin");

        List<GarbageBinDTO> garbageBinDTOs = garbageBins.stream()
                .map(bin -> modelMapper.map(bin, GarbageBinDTO.class))
                .collect(Collectors.toList());

        return garbageBinDTOs;
    }

    public List<GarbageBinDAO> getAllGarbageBinData(){
            List<GarbageBin> garbageBins = garbageBinRepository.findAll();
            return modelMapper.map(garbageBins,new TypeToken<List<GarbageBinDAO>>(){}.getType());
    }

    public double[][] getAvailableBinsIdAndFilledVolume(){

        List<String> statusList = Arrays.asList("filled bin","origin");

        List<GarbageBin> availableBins = garbageBinRepository.findByStatusIn(statusList);

        double[][] binInfoArray = new double[availableBins.size()][2];

        for (int i = 0; i < availableBins.size(); i++) {
            GarbageBin bin = availableBins.get(i);
            binInfoArray[i][0] = bin.getId(); // Store bin ID
            binInfoArray[i][1] = bin.getFilledVolume(); // Store filled volume
        }

        return binInfoArray;
    }




    public String addBinDetails(GarbageBinDTO garbageBinDTO){
        GarbageBin garbageBin=modelMapper.map(garbageBinDTO,GarbageBin.class);
        if(!garbageBinRepository.existsById(garbageBinDTO.getId())) {
            if (garbageBinDTO.getLocationType().equals("Residence")){
                garbageBin.setNumOfHouses(garbageBinDTO.getNumOfHouses());
            }
            garbageBinRepository.save(garbageBin);
            return VarList.RSP_SUCCESS;
        }
        else
            return VarList.RSP_DUPLICATED;
    }


    //method to input iot data
    public void inputIOTData(int id,double filledHeight,double longitude,double latitude){
        GarbageBin garbageBin= garbageBinRepository.findGarbageBinById(id);
        garbageBin.setFilledLevel((float) filledHeight);
        garbageBin.setLongitude(longitude);
        garbageBin.setLatitude(latitude);

        garbageBinRepository.save(garbageBin);
    }



}
