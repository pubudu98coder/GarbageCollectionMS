package com.FinalYearProject.GarbageCollectionMS.service;

import com.FinalYearProject.GarbageCollectionMS.entity.Truck;
import com.FinalYearProject.GarbageCollectionMS.Repository.TruckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckCapacityService {

    @Autowired
    private TruckRepo truckRepo;

    @Autowired
    public TruckCapacityService(TruckRepo truckRepo) {
        this.truckRepo = truckRepo; // Injected here

        // Log the truckRepo object to verify that it is not null
        if (truckRepo == null) {
            throw new NullPointerException("truckRepo is null");
        }
        System.out.println("truckRepo = " + truckRepo);
    }

    public double[][] getAvailableTrucksIdAndCapacity() {
        List<Truck> availableTrucks = truckRepo.findByStatus("available");

        // Define a multidimensional array to store IDs and capacities
        double[][] truckInfoArray = new double[availableTrucks.size()][2];

        // Iterate through available trucks and store their IDs and capacities
        for (int i = 0; i < availableTrucks.size(); i++) {
            Truck truck = availableTrucks.get(i);
            truckInfoArray[i][0] = truck.getId(); // Store truck ID
            truckInfoArray[i][1] = (float) truck.getCapacity(); // Store truck capacity
        }

        return truckInfoArray;
    }



}
