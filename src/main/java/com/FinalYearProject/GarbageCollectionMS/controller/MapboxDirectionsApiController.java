package com.FinalYearProject.GarbageCollectionMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapboxDirectionsApiController {


    @GetMapping("/generateurl")
    public String generateUrl(
            @RequestParam(value = "startLongitude") double startLongitude,
            @RequestParam(value = "startLatitude") double startLatitude,
            @RequestParam(value = "endLongitude") double endLongitude,
            @RequestParam(value = "endLatitude") double endLatitude,
            @RequestParam(value = "accessToken") String accessToken) {

        String url = "https://api.mapbox.com/directions/v5/mapbox/cycling/" +
                startLongitude + "," + startLatitude + ";" +
                endLongitude + "," + endLatitude +
                "?geometries=geojson&access_token=" + accessToken;

        return url;
    }
}
