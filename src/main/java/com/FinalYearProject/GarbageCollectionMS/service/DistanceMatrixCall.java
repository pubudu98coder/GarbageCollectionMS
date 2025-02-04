package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.Repository.GarbageBinRepository;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service

public class DistanceMatrixCall {
    @Autowired
    private GarbageBinRepository garbageBinRepository;

    @Autowired
    private DistanceMatrixAPI distanceMatrixAPI;

    public long[][] callMatrix() throws ParseException {
        long count = garbageBinRepository.count();
        System.out.println("Count from repository: " + count);

        List<String> statusList = Arrays.asList("filled bin","origin");

        List<GarbageBin> binList = garbageBinRepository.findByStatusIn(statusList);



        //List<GarbageBin> binList = garbageBinRepo.findByStatus("filled bin");
        System.out.println("Size of binList: " + binList.size());

        // Handle empty list
        if (binList.isEmpty()) {
            return new long[0][0]; // Return empty matrix
        }

        long[][] matrix = new long[binList.size()][binList.size()];

        for (int i = 0; i < binList.size(); i++) {
            GarbageBin bin1 = binList.get(i);
            for (int j = i + 1; j < binList.size(); j++) {
                GarbageBin bin2 = binList.get(j);
                long distance = distanceMatrixAPI.getData((Double) bin1.getLatitude(), (Double) bin1.getLongitude(), (Double) bin2.getLatitude(), (Double) bin2.getLongitude());
                matrix[i][j] = distance;
                matrix[j][i] = distance;
            }
        }
        return matrix;
    }



}
