package com.api.earthquakes.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.earthquakes.model.EarthQuake;
import com.api.earthquakes.services.EarthquakesService;
import com.google.gson.Gson;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
@RequestMapping(path = "/earthquakes", produces = MediaType.APPLICATION_JSON_VALUE)
public class EarthquakesController {
	

	private static final Logger log = LoggerFactory.getLogger(EarthquakesController.class);
    @Autowired
    private EarthquakesService earthquakesService;

    
    @GetMapping(value = "/byDate/{starttime}/{endtime}",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<String> listEarthquakesByDate( @PathVariable("starttime") String starttime,
    										   @PathVariable("endtime") String endtime) { 

    			String param1 = "starttime";
    			String param2 = "endtime";
    			String value1 = starttime;
    			String value2 = endtime;
			try {
				
				List<String> earthQuakes = earthquakesService.callEqApi(param1,value1,param2,value2); 
				if(earthQuakes != null){
					return  earthQuakes;
				}

			} catch (Exception ex) {
				log.error("ws-queryEarthquakesByDate", ex);
			}
				return null;
			}
    
    @GetMapping(value = "/byMagnitude/{minmagnitude}/{maxmagnitude}",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<String> listEarthquakesByMagnitude( @PathVariable("minmagnitude") String minmagnitude,
    										   		@PathVariable("maxmagnitude") String maxmagnitude) { 

    		String param1 = "minmagnitude";
    		String param2 = "maxmagnitude";
    		String value1 = minmagnitude;
    		String value2 = maxmagnitude;
			try {
				
				List<String> earthQuakes = earthquakesService.callEqApi(param1,value1,param2,value2); 
				if(earthQuakes != null){
					return  earthQuakes;
				}

			} catch (Exception ex) {
				log.error("ws-queryEarthquakesByMagnitude", ex);
			}
				return null;
			}
    
    @GetMapping(value = "/today",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<String> listEarthquakesToday() { 
    	 
    	    int swi=0;
    	    String param1 = "";
			String param2 = "endtime";
			Date myDate = new Date();			
			String value1 = "";
			String value2 = new SimpleDateFormat("yyyy-MM-dd").format(myDate);
			Gson gson = new Gson();

			try {
				
				System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
				
				List<String> earthQuakes = earthquakesService.callEqApi(param1,value1,param2,value2); 
				if(earthQuakes != null){
						
					EarthQuake earthq= new EarthQuake();
					earthq.setStarttime(value1);
					earthq.setEndtime(value2);
					earthq.setMinmagnitude("");
					earthq.setMaxmagnitude("");
					earthq.setEarthquakes(gson.toJson(earthQuakes));
					
					swi= earthquakesService.create(earthq);
					
					return  earthQuakes;
				}

			} catch (Exception ex) {
				log.error("ws-queryEarthquakesToday", ex);
			}
				return null;
			}

}
