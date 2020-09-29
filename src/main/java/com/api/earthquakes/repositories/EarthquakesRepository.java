package com.api.earthquakes.repositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.api.earthquakes.model.EarthQuake;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Repository
public class EarthquakesRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<EarthQuake> {
		@Override
		public EarthQuake mapRow(ResultSet rs, int rowNum) throws SQLException {
			EarthQuake earthq = new EarthQuake();
			earthq.setId(rs.getLong("id"));
			earthq.setStarttime(rs.getString("start_time"));
			earthq.setStarttime(rs.getString("end_time"));
			earthq.setStarttime(rs.getString("min_magnitude"));
			earthq.setStarttime(rs.getString("max_magnitude"));
			earthq.setStarttime(rs.getString("earthquakes"));
			return earthq;
		}

	}
	
	private static final String targetURL = "https://earthquake.usgs.gov/fdsnws/event/1/";	
	static String json = "...";

			public List<String> callEqApiByParams(String param1, String value1 ,String param2,String value2) { 
				

					List<String> listFeature = new ArrayList<String>(); 
			          try {
			        	  
			        	  StringBuilder stringBuilder = new StringBuilder();
				            
				            stringBuilder.append(targetURL);
				            stringBuilder.append("query?format=geojson&");
				            stringBuilder.append(param1);
				            stringBuilder.append("=");
				            stringBuilder.append(value1);
				            stringBuilder.append("&");
				            stringBuilder.append(param2);
				            stringBuilder.append("=");
				            stringBuilder.append(value2);
				            
			        	    String finalURL = stringBuilder.toString();	        	     		 
			            URL restServiceURL = new URL(finalURL);
			            

			            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
			            httpConnection.setRequestMethod("GET");
			            httpConnection.setRequestProperty("Accept", "application/json");
			 
			            if (httpConnection.getResponseCode() != 200) {
			                throw new RuntimeException("HTTP GET Request Failed with Error code : "
			                        + httpConnection.getResponseCode());
			            }
			 
			            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
			                (httpConnection.getInputStream())));
			 
			            String output;	
			            
			            			          
			            while ((output = responseBuffer.readLine()) != null) {
			                   	    
			            	  json=output;			  
			           	    listFeature.add(json);
			               
			            }
			 
			           httpConnection.disconnect();	           
			 
			          } catch (MalformedURLException e) {
			            e.printStackTrace(); 
			          } catch (IOException e) { 
			            e.printStackTrace();	 
			          }
			          
					return listFeature;	
				
			}
			
			public int insert(EarthQuake earthquake) {
				return jdbcTemplate.update("insert into earthquake (id, start_time, end_time, min_magnitude, max_magnitude, earthquakes) " 
						+ "values(?,  ?, ?, ?, ?, ?)",
						new Object[] { earthquake.getId(), earthquake.getStarttime(), earthquake.getEndtime(), earthquake.getMinmagnitude(), earthquake.getMaxmagnitude(), earthquake.getEarthquakes() });
			}
	
	
	
}
