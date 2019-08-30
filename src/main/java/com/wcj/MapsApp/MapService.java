package com.wcj.MapsApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class MapService {
    @Value("${api_key}")
    private String apiKey;

    public void addCoordinates(Location location) {
    		//url for getting Geocoding data for city/state combo
    	// System.out.println("WCJ INITIALIZING addCoordinates method" + "          " + location);
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + 
        location.getCity() + "," + location.getState() + "&key=" + apiKey;
        
        //converts response from Google into lat/long
        RestTemplate restTemplate = new RestTemplate();
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        //System.out.println(url);
        //System.out.println(response);
        Location coordinates = response.getResults().get(0).getGeometry().getLocation();
        //System.out.println(coordinates);
        
        	//sets the lat/long for city/state to end up with all proper parameters for object "location"
        location.setLat(coordinates.getLat());
        location.setLng(coordinates.getLng());
        //System.out.println(location);
    }

	public void randomCoordinates(Location location) {
		System.out.println("WCJ randomCoordinates METHOD INITIALIZED                  " + location);
		
	}
}