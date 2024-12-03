package com.synergy.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.domain.*;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

public List<Hotel> findByHotelNameLikeOrCityLikeOrStateLikeAllIgnoreCase(String name,String city,String state );

public Hotel findByHotelNameAllIgnoreCase(String name);

public Hotel findByHotelId(int hotelid);


}
