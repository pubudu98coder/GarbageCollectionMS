package com.FinalYearProject.GarbageCollectionMS.service;



import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.maps.model.DistanceMatrixElement;
import java.util.Arrays;
import java.util.List;

@Service
public class DistanceMatrixService {

    private final GeoApiContext context;

    @Autowired
    public DistanceMatrixService(GoogleMapsConfig config) {
        this.context = new GeoApiContext.Builder()
                .apiKey(config.getApiKey())
                .build();
    }

    public String getDistances(List<String> origins, List<String> destinations) {
        try {
            DistanceMatrix matrix = DistanceMatrixApi.newRequest(context)
                    .origins(origins.toArray(new String[0]))
                    .destinations(destinations.toArray(new String[0]))
                    .mode(TravelMode.DRIVING)
                    .await();

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < matrix.rows.length; i++) {
                for (int j = 0; j < matrix.rows[i].elements.length; j++) {
                    DistanceMatrixElement element = matrix.rows[i].elements[j];
                    result.append("Distance from ")
                            .append(origins.get(i))
                            .append(" to ")
                            .append(destinations.get(j))
                            .append(": ")
                            .append(element.distance.humanReadable)
                            .append("\n");
                }
            }
            return result.toString();
        } catch (Exception e) {
            return "Error calculating distances: " + e.getMessage();
        }
    }
}