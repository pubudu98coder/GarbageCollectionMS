package com.FinalYearProject.GarbageCollectionMS.service;

import com.google.ortools.Loader;
import com.google.ortools.constraintsolver.*;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleSelector {

    @Autowired
    private DistanceMatrixCall distanceMatrixCall;

    public final int vehicleNumber = 4;
    public final int depot =0;
    int length = 4;






    public void routeFinder() throws ParseException {
        Loader.loadNativeLibraries();

        // Create an instance of DistanceMatrixCall
        //DistanceMatrixCall distanceMatrixCall = new DistanceMatrixCall();

        // Get the distance matrix
        long[][] distanceMatrix = distanceMatrixCall.callMatrix();

        // Create a RoutingIndexManager
        RoutingIndexManager manager = new RoutingIndexManager(length, vehicleNumber, depot);

        // Create a RoutingModel
        RoutingModel routing = new RoutingModel(manager);

        // Register transit callback
        final int transitCallbackIndex = routing.registerTransitCallback((long fromIndex, long toIndex) -> {
            int fromNode = manager.indexToNode(fromIndex);
            int toNode = manager.indexToNode(toIndex);
            return distanceMatrix[fromNode][toNode];
        });

        routing.setArcCostEvaluatorOfAllVehicles(transitCallbackIndex);
        routing.addDimension(transitCallbackIndex, 0, 3000, true, "Distance");

        RoutingDimension distanceDimension = routing.getMutableDimension("Distance");
        distanceDimension.setGlobalSpanCostCoefficient(100);

        RoutingSearchParameters searchParameters = main.defaultRoutingSearchParameters()
                .toBuilder()
                .setFirstSolutionStrategy(FirstSolutionStrategy.Value.PATH_CHEAPEST_ARC)
                .build();

        Assignment solution = routing.solveWithParameters(searchParameters);

        for (int i = 0; i < vehicleNumber; ++i) {
            System.out.println("Route for Vehicle " + i + ":");
            long index = routing.start(i);
            while (!routing.isEnd(index)) {
                System.out.print(manager.indexToNode(index) + " -> ");
                index = solution.value(routing.nextVar(index));
            }
            System.out.println(manager.indexToNode(index));
        }
    }


}
