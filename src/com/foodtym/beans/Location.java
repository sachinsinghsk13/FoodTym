package com.foodtym.beans;

public class Location {
	private int id;
	private String locality;
	private String region;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String localityName) {
		this.locality = localityName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
}
