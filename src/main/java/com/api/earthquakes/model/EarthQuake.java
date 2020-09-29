package com.api.earthquakes.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class EarthQuake {
	
	@Id
	@GeneratedValue
	private long id;
	private String starttime;
	private String endtime;
	private String minmagnitude;
	private String maxmagnitude;
	private String earthquakes;
	
	/**
	 * 
	 */
	public EarthQuake() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param starttime
	 * @param endtime
	 * @param minmagnitude
	 * @param maxmagnitude
	 * @param earthquakes
	 */
	public EarthQuake(long id, String starttime, String endtime, String minmagnitude, String maxmagnitude,
			String earthquakes) {
		super();
		this.id = id;
		this.starttime = starttime;
		this.endtime = endtime;
		this.minmagnitude = minmagnitude;
		this.maxmagnitude = maxmagnitude;
		this.earthquakes = earthquakes;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the starttime
	 */
	public String getStarttime() {
		return starttime;
	}
	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	/**
	 * @return the endtime
	 */
	public String getEndtime() {
		return endtime;
	}
	/**
	 * @param endtime the endtime to set
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	/**
	 * @return the minmagnitude
	 */
	public String getMinmagnitude() {
		return minmagnitude;
	}
	/**
	 * @param minmagnitude the minmagnitude to set
	 */
	public void setMinmagnitude(String minmagnitude) {
		this.minmagnitude = minmagnitude;
	}
	/**
	 * @return the maxmagnitude
	 */
	public String getMaxmagnitude() {
		return maxmagnitude;
	}
	/**
	 * @param maxmagnitude the maxmagnitude to set
	 */
	public void setMaxmagnitude(String maxmagnitude) {
		this.maxmagnitude = maxmagnitude;
	}
	/**
	 * @return the earthquakes
	 */
	public String getEarthquakes() {
		return earthquakes;
	}
	/**
	 * @param earthquakes the earthquakes to set
	 */
	public void setEarthquakes(String earthquakes) {
		this.earthquakes = earthquakes;
	}
	
	

}
