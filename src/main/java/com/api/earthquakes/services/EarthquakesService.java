package com.api.earthquakes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.earthquakes.model.EarthQuake;
import com.api.earthquakes.repositories.EarthquakesRepository;



@Service
public class EarthquakesService {
	
    @Autowired
    EarthquakesRepository earthquakesRepository;

    public List<String> callEqApi(String param1,String value1 ,String param2,String value2) {  
		
		  List<String> earthquakes = new ArrayList<String>();
		  earthquakes=earthquakesRepository.callEqApiByParams(param1,value1,param2,value2); 
	
	        return earthquakes;
	} 
    
    public int create(EarthQuake earthquake) {
        return earthquakesRepository.insert(earthquake);
    }


}
