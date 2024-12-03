package com.synergy.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.domain.Amenities;
import com.synergy.domain.Hotel;
import com.synergy.domain.HotelRoom;


import com.synergy.repository.RoomTypeRepository;
import com.synergy.repository.*;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
	
	
	@Autowired
	RoomTypeRepository roomtypeRepository;
	@Autowired
	HotelRepository hotelRepository;
	
	
		@Override
	 public List<String> getAllRoomTypes(String searchtext) {	
			
		Hotel hotel= hotelRepository.findByHotelNameAllIgnoreCase(searchtext);
		List<String> listroomtypes=new ArrayList<>();
		
			for(HotelRoom str:hotel.getHotelRooms()){
				String roomtype=str.getType().getName();
				if (listroomtypes.contains(roomtype))
				continue;
				else
				listroomtypes.add(roomtype);
			                                        }
			return listroomtypes;
                                                       		}
	
                                                            }
