package com.wcj.MapsApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MapController {
	
	@Autowired
	private MapService mapService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	   public String displayMap(Model model) {
	       model.addAttribute("location", new Location());
	       return "index.html";
	   }
	
	@GetMapping("/home")
	public String getDefaultMap(Model model) {
	   model.addAttribute(new Location());
		
		//System.out.println("WCJ MAKING A CALL OF getDefaultMap METHOD");
		Location location = new Location();
		location.setCity("Charlotte");
		location.setState("NC");
		mapService.addCoordinates(location);
		//System.out.println(location);
		//System.out.println(mapService);
	    return "index.html";
    }
	@PostMapping("/home")
	public String getMapForLocation(Location location, Model model) {
		mapService.addCoordinates(location);
	    model.addAttribute(location);
	    return "index.html";
	}
	
	@GetMapping("/random")
	public String getRandomMap(Model model) {
	   model.addAttribute(new Location());
		
		System.out.println("WCJ MAKING A CALL OF getRandomMap METHOD");
		Location location = new Location();
		location.setCity("Charlotte");
		location.setState("NC");
		mapService.randomCoordinates(location);
		System.out.println(location);
		System.out.println(mapService);
	    return "index.html";
    }
	@PostMapping("/random")
	public String randMapForLocation(Location location, Model model) {
		mapService.addCoordinates(location);
	    model.addAttribute(location);
	    return "index.html";
	}
	
}