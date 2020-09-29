package com.api.test.earthquakes.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;


import com.api.earthquakes.controller.EarthquakesController;

import com.api.earthquakes.services.EarthquakesService;



@RunWith(MockitoJUnitRunner.class)
public class EarthQuakesControllerTest {
	 @Mock
	  private EarthquakesService restClientService;

	  private EarthquakesController controller;
	  
	  private List<String> earthquakes; 
	  
	  private String param1;
	  private String value1;
	  private String param2;
	  private String value2;
	 
	  
	  @Before
	  public void setup() throws Exception {

	    controller = new EarthquakesController();
	    ReflectionTestUtils.setField(controller, "earthquakeService", restClientService);
	    
	    this.earthquakes = new ArrayList<String>();
	    this.earthquakes.add(new String());
	    	   	       
	    when(restClientService.callEqApi(param1, value1, param2, value2)).thenReturn(earthquakes);
	    	    	    
	  }
	  
	  @Test
	  public void testByDate() throws Exception {
	    assertEquals(this.earthquakes.size(), 1);
	   // Person person = new Person();
	    param1="starttime";
	    value1="2014-01-01";
	    param2="endtime";
	    value2="2014-01-02";
	    this.controller.listEarthquakesByDate(value1, value2);	   
	    assertEquals(this.earthquakes.size(), 2);
	  }
	  
	  @Test
	  public void testByMagnitude() throws Exception { 
	    assertEquals(this.earthquakes.size(), 1);
	   // Person person = new Person();
	    param1="minmagnitude";
	    value1="6.5";
	    param2="maxmagnitude";
	    value2="7";
	    this.controller.listEarthquakesByMagnitude(value1, value2);	   
	    assertEquals(this.earthquakes.size(), 2);
	  }
	  
	  @Test
	  public void testToday() throws Exception { 
	    assertEquals(this.earthquakes.size(), 1);
	   // Person person = new Person();
	    this.controller.listEarthquakesToday();	   
	    assertEquals(this.earthquakes.size(), 2);
	  }
	  
		 

}
