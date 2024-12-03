package com.synergy.service;

import java.util.ArrayList;



import java.util.Iterator;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.synergy.domain.Amenities;
import com.synergy.domain.Hotel;
import com.synergy.domain.HotelRoom;
import com.synergy.domain.Review;
import com.synergy.repository.AmenitiesRepository;
import com.synergy.repository.HotelRepository;
import com.synergy.repository.HotelRoomRepository;
import com.synergy.repository.QuestionsRepository;
import com.synergy.repository.ReviewRepository;
import com.synergy.model.Filter;
import com.synergy.domain.Questions;





@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	HotelRoomRepository hotelRoomRepository;
	
	@Autowired
	AmenitiesRepository amenitiesRepository;
	
	@Autowired
	QuestionsRepository questionRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	
	
	@Override
	public List<Hotel> getHotelsBySearchText(String searchtext) {
		searchtext="%"+ searchtext +"%";
		
		List<Hotel> listhotel=hotelRepository.findByHotelNameLikeOrCityLikeOrStateLikeAllIgnoreCase(searchtext,searchtext, searchtext);
		//return hotelRepository.findByHotelNameLikeOrCityLikeOrStateLikeAllIgnoreCase(searchtext,searchtext, searchtext);
		List<Hotel> listHotelRating = new ArrayList<Hotel>();
		for (Hotel str:listhotel) {
		List<Review> listreview=reviewRepository.findByHotelId(str.getHotelId());
		double i=0;
		for(Review str1:listreview) {
			i=i+ str1.getRatings();
		}
		double OverallRating=i/listreview.size();
		str.setRating(OverallRating);
		listHotelRating.add(str);
		}
		return listHotelRating;
	}

	@Override
	public List<Hotel> findHotels(Filter filter){
		
		List<Hotel> listhotel=getHotelsBySearchText(filter.getSearchText());
		Iterator<Hotel> itr = listhotel.iterator();
        List<Hotel> listExistHotel = new ArrayList<Hotel>();
       
          outer:
           while(itr.hasNext()) {
	         Hotel hotel = itr.next();
	         for (int str : filter.getStarRating()) {
	        	if(str== hotel.getStarRating()) { 
	        	   if(filter.getPriceRange()<=hotel.getAveragePrice()) {
	               int count=0;
	               for (String str1: filter.getAmenities()) {
	                	for(Amenities str2: hotel.getAmenities()) {
	            		if(str1.equalsIgnoreCase(str2.getName())) { 
	            		   count++;
	            		if(count==filter.getAmenities().size()) {
	            		   listExistHotel.add(hotel);    
	            		   continue outer;   } } }  } } } }  }
          
		          List<Hotel> listHotelRating = new ArrayList<Hotel>();
		  		for (Hotel str:listExistHotel) {
		  		List<Review> listreview=reviewRepository.findByHotelId(str.getHotelId());
		  		double i=0;
		  		for(Review str1:listreview) {
		  			i=i+ str1.getRatings();
		  		}
		  		double OverallRating=i/listreview.size();
		  		str.setRating(OverallRating);
		  		listHotelRating.add(str);
		  		}
		  		return listHotelRating;
          
            // return listExistHotel; 
             }

	
    @Override
	public List<HotelRoom> getHotelRooms(String hotelId, String roomtype) {
    	
    	int Hotelid = Integer.parseInt(hotelId);
    	
    	System.out.println("in hotel service hotel id "+ hotelId);
    	
    	System.out.println("Inside Hotelservice 1 ");
    	Hotel hotel=hotelRepository.findByHotelId(Hotelid);
    	List<HotelRoom> listHotelroom = new ArrayList<HotelRoom>();
    	       	for(HotelRoom str:hotel.getHotelRooms()) {
    	       		System.out.println("Inside for loop hotelroom "+ str.getType().getName());
    		if(str.getType().getName().equalsIgnoreCase(roomtype)) {   
    			listHotelroom.add(str);
    		                                       }
    			
    		                                             }
    	       	System.out.println("Inside Hotelservice 2 ");
    	       	return listHotelroom;
    	       	
    	                                                                }
    @Override
	public HotelRoom getDiscountPrice(int hotelroomid) {
		
		HotelRoom hotelroom=hotelRoomRepository.findByHotelRoomId(hotelroomid);	
		return hotelroom;
	}

    @Override
	public String getHotelName(int hotelid) {
    	
    	System.out.println("inside hotel service hotel name ");
    	
    //	int Hotelid = Integer.parseInt(hotelid2);
    	
    	Hotel hotel= hotelRepository.findByHotelId(hotelid);   
    	
    	System.out.println("inside hotel service hotel name 222 ");
	
		return hotel.getHotelName();
	}
    
    @Override
	public List<Questions> getAllQuestions() {  
		
		return questionRepository.findAll();
	}

    @Override
	public Review addReview(Review review) {
    	
    return 	reviewRepository.save(review);
		
	}

    @Override
	public List<Review> getHotelReview(int hotelid) {
    	
    	return reviewRepository.findByHotelId(hotelid);
		
	}
    
     
       }
	                                                                                  
	              
	              
	                                                                                  
	              
	              
	                     

	
                                                   



