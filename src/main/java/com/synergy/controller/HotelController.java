package com.synergy.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.synergy.domain.Hotel;
import com.synergy.domain.HotelRoom;
import com.synergy.domain.Questions;
import com.synergy.domain.Review;
import com.synergy.service.HotelServiceImpl;
import com.synergy.service.RoomTypeServiceImpl;
import com.synergy.model.Filter;

@RestController
public class HotelController {
	
	
	@Autowired
	HotelServiceImpl hotelService;	
	
	@Autowired
	RoomTypeServiceImpl roomtypeservice;
	
	
	
	
	@RequestMapping(value="/getHotelsBytext/{searchtext}")
	public List<Hotel> getHotelsBySearchtext(@PathVariable String searchtext){
	return hotelService.getHotelsBySearchText(searchtext);
	}
	
	@RequestMapping(value="/getAllRoomType/{searchtext}")
	public List<String> getAllRoomType(@PathVariable String searchtext) {
	return roomtypeservice.getAllRoomTypes(searchtext);
		
	}
	
	@RequestMapping(value="/findHotels",method = RequestMethod.POST)
	public List<Hotel> findHotels(@RequestBody Filter filter) {
	return hotelService.findHotels(filter);
	}
	
	@RequestMapping(value="/getHotelRoomsDetails/{hotelId}/{roomtype}")
	public List<HotelRoom> getHotelRooms(@PathVariable String hotelId,@PathVariable String roomtype) {
		System.out.println("Inside Hotelcontroller ");
	return hotelService.getHotelRooms(hotelId,roomtype);
		
	}
	
	@RequestMapping(value="/getDiscountPrice/{hotelroomid}")
	public HotelRoom getDiscountPrice(@PathVariable int hotelroomid) {
	return hotelService.getDiscountPrice(hotelroomid);
		
	}
	
	
	@RequestMapping(value="/getHotelName/{hotelid}")
	public JsonNode getHotelName(@PathVariable int hotelid) {
		System.out.println("inside hotel controller get hotel name  ");
		String s=hotelService.getHotelName(hotelid);
		System.out.println("Print s "+ s);
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=mapper.createObjectNode();
		((ObjectNode) node).put("hotelname",s);
	return node;
		
	}
	
	@RequestMapping(value="/getAllQuestions")
	public List<Questions> getAllQuestions() {
		System.out.println("inside gateway controller getAllQuestions");
	return hotelService.getAllQuestions();		
	}
	
	
	@RequestMapping(value="/addReview" ,method = RequestMethod.POST)
	public Review addReview(@RequestBody Review  review){
	System.out.println("in Booking Controller add review");		
	return hotelService.addReview(review);
	}
	
	@RequestMapping(value="/getHotelReview/{hotelid}")
	public List<Review> getHotelReview(@PathVariable int hotelid) {
    System.out.println("inside gateway controller getHotelReview");
	return hotelService.getHotelReview(hotelid);		
	}
	
	    
		
		

	
		
		
	
	}
	                          

