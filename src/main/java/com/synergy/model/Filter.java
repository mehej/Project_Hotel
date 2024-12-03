package com.synergy.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Filter {

	
	private String searchText;
	private int filterId;
	private List<Integer> starRating;
	private List<String> amenities;	
	private double priceRange;
	
	public Filter(String searchText, int filterId, List<Integer> starRating, List<String> amenities,
			double priceRange) {
		super();
		this.searchText = searchText;
		this.filterId = filterId;
		this.starRating = starRating;
		this.amenities = amenities;
		this.priceRange = priceRange;
	}
	public List<Integer> getStarRating() {
		return starRating;
	}
	public void setStarRating(List<Integer> starRating) {
		this.starRating = starRating;
	}
	public List<String> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}
	public double getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(double priceRange) {
		this.priceRange = priceRange;
	}
	
	public Filter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	
	
	
	
	
	
	
	
	
	
}
