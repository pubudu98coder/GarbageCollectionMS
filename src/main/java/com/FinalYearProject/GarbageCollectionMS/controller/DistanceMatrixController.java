package com.FinalYearProject.GarbageCollectionMS.controller;

import com.FinalYearProject.GarbageCollectionMS.service.DistanceMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/distanceMatrix")
public class DistanceMatrixController {


    private final DistanceMatrixService service;

    @Autowired
    public DistanceMatrixController(DistanceMatrixService service) {
        this.service = service;
    }

    @PostMapping("/distances")
    public String getDistances(@RequestBody DistanceMatrixRequest request) {
        return service.getDistances(request.getOrigins(), request.getDestinations());
    }

    public static class DistanceMatrixRequest {
        private List<String> origins;
        private List<String> destinations;

        public List<String> getOrigins() {
            return origins;
        }

        public void setOrigins(List<String> origins) {
            this.origins = origins;
        }

        public List<String> getDestinations() {
            return destinations;
        }

        public void setDestinations(List<String> destinations) {
            this.destinations = destinations;
        }
    }
}
