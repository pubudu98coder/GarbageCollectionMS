package com.FinalYearProject.GarbageCollectionMS.service;

import org.hibernate.metamodel.internal.AbstractEntityInstantiatorPojo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Service
public class DistanceMatrixAPI {

    public long getData(Double originLatitude, Double originLongitude, Double destinationLatitude1, Double destinationLongitude1) throws ParseException {
        if (originLatitude == null || originLongitude == null || destinationLatitude1 == null || destinationLongitude1 == null) {
            throw new IllegalArgumentException("Origin and destination coordinates must be provided");
        }

        if (originLatitude == 0 || originLongitude == 0 || destinationLatitude1 == 0 || destinationLongitude1 == 0) {
            throw new IllegalArgumentException("Origin and destination coordinates must be non-zero");
        }

        var url = "https://maps.googleapis.com/maps/api/distancematrix/json?" +
                "destinations=" + destinationLatitude1 + "%2C" + destinationLongitude1 +
                "&origins=" + originLatitude + "%2C" + originLongitude +
                "&key=" + "AIzaSyArFpNCJi0QIRiLIuVA3gGVNjRa4GGy6WU";

        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        String response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            if (response.contains("ERROR")) {
                throw new Exception("API error: " + response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        JSONParser jp = new JSONParser();
        JSONObject jo = (JSONObject) jp.parse(response);
        JSONArray ja =  (JSONArray) jo.get( "rows");

        jo = (JSONObject) ja.get(0);
        ja = (JSONArray) jo.get("elements");
        jo = (JSONObject) ja.get(0);
        JSONObject je = (JSONObject) jo.get("distance");
        long distance = (long) je.get("value");

        return distance;




        //return response;
    }



}
