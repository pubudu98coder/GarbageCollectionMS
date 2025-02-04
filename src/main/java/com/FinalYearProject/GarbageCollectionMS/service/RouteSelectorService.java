package com.FinalYearProject.GarbageCollectionMS.service;


import jakarta.annotation.PostConstruct;
import org.hibernate.dialect.function.array.ArrayToStringFunction;
import org.json.simple.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RouteSelectorService {

    @Autowired
    private DistanceMatrixCall distanceMatrixCall;
    @Autowired
    private TruckCapacityService truckCapacityService;
    @Autowired
    private GarbageBinService garbageBinService;
    private ModelMapper modelMapper;

    //Store the matrix received by DistanceMatrixCall
    private long[][] matrix;
    //Store the id and capacity of trucks whose status is "available"
    private double[][] truckArray;
    //Store the id and filled volume of garbage bins whose status is "available" and status is "origin"
    private double[][] filledBinInfo;
    //Store the id of truck whose capacity is highest which is not included in usedTrucks array
    int maxVehicleID = 0;
    ////Store the capacity of truck whose capacity is highest which is not included in usedTrucks array
    double maxVehicleCap = 0;
    //Store the total volume of collected bins
    double totalVolume = 0;
    //Store the bin order and vehicle id of all paths
    String[][] allDetails;
    //Store the id's of used vehicles
    int[] usedVehicles = new int[6];
    int j;
    //To check whether the truck is used
    int alreadyUsedTruck = 0;
    //Store the count of bins visited
    int visitedBinCount = 0;
    //Store the id of truck which is assigned to a path
    int assignedVehicle = 0;
    // To store the indexes of locations to visit, for a one vehicle. First and last element should be origin. therefor length is matrix.length+1. Matrix includes 1 origin
    int[] binOrder ;
    //Store the actual id's of bins
    int[] actualBinOrder;
    //Store the indexes of all visited bins
    int[] allVisitedBins;
    // To store the distance for the last visited location
    long minDistance = Long.MAX_VALUE;
    // Add values to the binOrder array from index 1. After adding an element, it has to be incremented by 1
    int newIndex = 1;
    //Store the index of first location to visit after origin
    int firstIndex = 1;
    //To check whether it is an already visited as the first location after the origin
    int alreadyFirstIndex =0;

    @Autowired
    public RouteSelectorService(DistanceMatrixCall distanceMatrixCall,ModelMapper modelMapper,TruckCapacityService truckCapacityService,GarbageBinService garbageBinService) {

        this.distanceMatrixCall = distanceMatrixCall;
        this.modelMapper = modelMapper;
        this.truckCapacityService = truckCapacityService;
        this.garbageBinService = garbageBinService;

    }

    // This method annotated with @PostConstruct to initialize variables after dependencies are injected
    @PostConstruct
    private void initializeVariables() {
        // Initialize truckArray and filledBinInfo here
        this.truckArray = truckCapacityService.getAvailableTrucksIdAndCapacity();
        this.filledBinInfo = garbageBinService.getAvailableBinsIdAndFilledVolume();

    }

    // This method annotated with @PostConstruct to initialize variables after dependencies are injected
    @PostConstruct
    private void initializeMatrix() {
        try {
            this.matrix = distanceMatrixCall.callMatrix();
            binOrder = new int[matrix.length + 1];
            allDetails = new String[5][2];
            actualBinOrder = new int[binOrder.length];
            allVisitedBins= new int[matrix.length];
        } catch (ParseException e) {
            throw new RuntimeException("Failed to initialize matrix", e);
        }

    }

    // This method annotated with @PostConstruct to initialize variables after dependencies are injected
    @PostConstruct
    public long[][] callMatrix2() throws ParseException {

        return distanceMatrixCall.callMatrix();

    }


    /*Function to assign the shortest path
     Always starts with the closest location(location 1) to the origin.Then it finds the location(location 2) closest to the
     previous location(location 1).Likewise the method continues until all the bins are assigned to a route with a truck
     whose status is "available"*/
    public String[][] getShortestPath() {

        //choose the vehicle with maximum capacity. Returns the ID of that vehicle.
        //truckArray.length=6
        maxVehicleCap = 0;
        alreadyUsedTruck = 0;

        for (int i = 0; i < truckArray.length; i++) {

            alreadyUsedTruck = 0;

            /* Following souts are used to check the iterations are properly working */
            //float id = truckArray[i][0];
            //float size= truckArray[i][1];
            //System.out.println("id "+id+" size "+size);

            //second of each array represents the capacity of a truck
            if (truckArray[i][1] > maxVehicleCap) {

                for (j = 0; j < usedVehicles.length; j++) {

                    /*checks whether the id of a truck includes in the usedVehicle array.
                     If it is, we don't use that truck again*/
                    if (truckArray[i][0] == usedVehicles[j]) {

                        alreadyUsedTruck = 1;
                        break;
                    }
                }

                //if it is not used already
                if (alreadyUsedTruck != 1) {

                    maxVehicleCap = truckArray[i][1];
                    maxVehicleID = (int) truckArray[i][0];

                    System.out.println("maxVehicleID "+maxVehicleID+" maxVehicleCap "+maxVehicleCap);
                }


            }

        }

        assignedVehicle = maxVehicleID;

        // Mark the assigned vehicle as used
        for (int q=0; q<usedVehicles.length; q++) {
            if (usedVehicles[q] == 0) {
                usedVehicles[q] = assignedVehicle;
                break;
            }
        }

        /* Following souts are used to check the iterations are properly working */
       // System.out.println("usedVehicles "+Arrays.toString(usedVehicles));


        // Find the closest location to the municipal council (origin)
        for (int j = 0; j < matrix[0].length; j++) {
            alreadyFirstIndex =0;
            if (matrix[0][j] != 0 && matrix[0][j] < minDistance) {

                for(int p=0; p<allVisitedBins.length;p++){

                    if(allVisitedBins[p]==j){
                        alreadyFirstIndex=1;
                    }
                }

                if(alreadyFirstIndex!=1){

                    minDistance = matrix[0][j];
                    firstIndex = j;
                }


            }
        }

        /* Following souts are used to check the iterations are properly working */
        //System.out.println("closest location to the origin"+" "+firstIndex);

        // Assign the first location to visit after origin
        binOrder[1] = firstIndex;
        actualBinOrder[1] = (int) filledBinInfo[firstIndex][0];

        /* Following souts are used to check the iterations are properly working */
        //System.out.println("binOrder after firstIndex "+Arrays.toString(binOrder) );
        //System.out.println("actualBinOrder after firstIndex "+Arrays.toString(actualBinOrder) );

        for(int v=0;v<allVisitedBins.length;v++){

            if(allVisitedBins[v]==0){
                allVisitedBins[v]= firstIndex;
                break;
            }

        }

        /* Following souts are used to check the iterations are properly working */
       // System.out.println("allVisitedBins after firstIndex "+Arrays.toString(allVisitedBins) );

        // Add the filled volume of the first index to the total volume
        totalVolume += filledBinInfo[firstIndex][1]; //20
        visitedBinCount++; //1

        /* Following souts are used to check the iterations are properly working */
        //System.out.println("totalVolume after firstIndex "+totalVolume+" "+"visitedBinCount "+visitedBinCount );

        // Then find the closest location to the first location
        int k = binOrder[1];  //k=2 //3

        // Minimum value in the array
        long minDisArray = Long.MAX_VALUE;

        // To store the index of next location
        int arrIndex = 0;

        int alreadyIndex =0;


        while (visitedBinCount <= allVisitedBins.length) {

            // Iterate through distances matrix to find the closest location
            for (int n = 1; n < matrix[k].length; n++) {

                alreadyIndex=0;

                // Conditions for selecting the next location
                if (matrix[k][n]!= 0 && matrix[k][n]!= minDistance && matrix[k][n] < minDisArray && n!=k) {

                    for(int i=0; i<binOrder.length;i++){

                        if(binOrder[i]==n){

                            alreadyIndex =1;
                            break;
                        }
                    }
                    for(int j=0;j<allVisitedBins.length;j++){

                        if(allVisitedBins[j]==n){

                            alreadyIndex =1;
                            break;
                        }
                    }

                    // If the index is not in the queue
                    if(alreadyIndex!=1){

                        minDisArray = matrix[k][n];
                        arrIndex = n;

                    }

                }
            }

            if(arrIndex!=0) {

                int exceedBinLimit=0;

                exceedBinLimit = (int) (totalVolume+filledBinInfo[arrIndex][1]);

                if(exceedBinLimit<=maxVehicleCap) {


                    // Move the index to the next position after adding a value to the binOrder queue
                    newIndex++;
                    binOrder[newIndex] = arrIndex;
                    visitedBinCount++;
                    actualBinOrder[newIndex] = (int) filledBinInfo[arrIndex][0];
                    k = arrIndex;

                    for (int u = 0; u < allVisitedBins.length; u++) {

                        if (allVisitedBins[u] == arrIndex) {

                            break;
                        }

                        if (allVisitedBins[u] == 0) {
                            allVisitedBins[u] = arrIndex;
                            break;
                        }

                    }


                    // Store the distance with the last visited location
                    minDistance = minDisArray;

                    minDisArray = Long.MAX_VALUE;

                    // Add the filled volume of a bin to the total volume
                    totalVolume += filledBinInfo[arrIndex][1]; //120
                }else {

                    break;
                }

                if (totalVolume >= maxVehicleCap) {
                    break;
                }


            }else{
                break;

            }
        }



        /* Following souts are used to check the iterations are properly working */
        //System.out.println("allVisitedBins after other indexes "+Arrays.toString(allVisitedBins) );
        //System.out.println("totalVolume after other indexes "+totalVolume+" "+"visitedBinCount "+visitedBinCount );

        String vehicle = String.valueOf(assignedVehicle);
        String order = Arrays.toString(actualBinOrder);

        /* Following souts are used to check the iterations are properly working */
        //System.out.println(vehicle+" "+order);

        for(int t=0;t<allDetails.length;t++){

            if(allDetails[t][0]==null){

                allDetails[t][0] = vehicle;
                allDetails[t][1] = order;
                break;

            }

        }

        // Recursively call getShortestPath until all bins are assigned
        if (visitedBinCount < filledBinInfo.length-1) {
            minDistance = Long.MAX_VALUE;
            minDisArray = Long.MAX_VALUE;
            binOrder = new int[matrix.length + 1];
            actualBinOrder = new int[binOrder.length];
            totalVolume=0;
            newIndex=1;

            getShortestPath();
        }
        /* Following souts are used to check the iterations are properly working */
        /*System.out.println("********** after all iterations *************");
        System.out.println("actualBinOrder after firstIndex "+Arrays.toString(actualBinOrder) );
        System.out.println("allVisitedBins after other indexes "+Arrays.toString(allVisitedBins) );
        System.out.println("totalVolume after other indexes "+totalVolume+" "+"visitedBinCount "+visitedBinCount );*/

        //String all = Arrays.toString(allVisitedBins);
        //System.out.println(all);

        return allDetails;
    }

}