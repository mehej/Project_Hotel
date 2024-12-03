package com.synergy.service;


import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.synergy.domain.Hotel;
import com.synergy.domain.HotelRoom;
import com.synergy.domain.Questions;
import com.synergy.domain.Review;
import com.synergy.model.Filter;

public interface HotelService {
	
	public List<Hotel> getHotelsBySearchText(String searchtext);	
	public List<Hotel> findHotels(Filter filter);	
	public List<HotelRoom> getHotelRooms(String hotelId, String roomtype);	
	public HotelRoom getDiscountPrice(int hotelroomid);
	public String getHotelName(int hotelid);
	public List<Questions> getAllQuestions();
	public Review addReview(Review review);
	public List<Review> getHotelReview(int hotelid);
}
