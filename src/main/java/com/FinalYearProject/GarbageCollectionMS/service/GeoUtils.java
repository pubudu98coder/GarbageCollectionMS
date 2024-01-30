package com.FinalYearProject.GarbageCollectionMS.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import java.util.List;

public class GeoUtils {

    private final GeoApiContext context;

    public GeoUtils(GoogleMapsConfig config) {
        this.context = new GeoApiContext.Builder()
                .apiKey(config.getApiKey())
                .build();
    }

    public String getAddress(LatLng latLng) throws Exception {
        GeocodingResult[] results = GeocodingApi.newRequest(context)
                .latlng(latLng)
                .await();

        if (results.length > 0) {
            return results[0].formattedAddress;
        } else {
            throw new Exception("Unable to find address for the given latlng");
        }
    }
}
