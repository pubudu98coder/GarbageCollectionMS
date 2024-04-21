package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.repo.GarbageBinRepo;
import com.google.ortools.constraintsolver.RoutingDimension;
import com.google.ortools.constraintsolver.RoutingIndexManager;
import com.google.ortools.constraintsolver.SWIGTYPE_p_absl__flat_hash_setT_operations_research__RoutingModel__DimensionIndex_t;
import org.hibernate.tool.schema.extract.spi.ForeignKeyInformation;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadata;
import org.springframework.stereotype.Service;
import com.google.ortools.Loader;

import java.util.Arrays;
import java.util.List;

@Service

public class DistanceMatrixCall {
    @Autowired
    private GarbageBinRepo garbageBinRepo;

    @Autowired
    private DistanceMatrixAPI distanceMatrixAPI;

    public long[][] callMatrix() throws ParseException {
        long count = garbageBinRepo.count();
        System.out.println("Count from repository: " + count);

        List<String> statusList = Arrays.asList("filled bin","origin");

        List<GarbageBin> binList = garbageBinRepo.findByStatusIn(statusList);



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
                long distance = distanceMatrixAPI.getData(bin1.getLatitude(), bin1.getLongitude(), bin2.getLatitude(), bin2.getLongitude());
                matrix[i][j] = distance;
                matrix[j][i] = distance;
            }
        }
        return matrix;
    }



}
