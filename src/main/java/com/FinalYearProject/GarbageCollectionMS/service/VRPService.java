package com.FinalYearProject.GarbageCollectionMS.service;

import ch.qos.logback.core.util.Loader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class VRPService {

    @Autowired
    private DistanceMatrixCall distanceMatrixCall;



    private static final Logger logger = Logger.getLogger(VRPService.class.getName());

    static class DataModel{

        @Autowired
        private DistanceMatrixCall distanceMatrixCall;
        public final long[] demands = {0, 1, 1, 2, 4, 2, 4, 8, 8, 1, 2, 1, 2, 4, 4, 8, 8};
        public final long[] vehicleCapacities = {15, 15, 15, 15};
        public final int vehicleNumber = 4;
        public final int depot = 0;


    }

    public void getRoute(){

        //Loader.loadNativeLibraries();

    }






}
