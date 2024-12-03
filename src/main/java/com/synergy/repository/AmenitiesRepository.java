package com.synergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.domain.Amenities;


@Repository
public interface AmenitiesRepository extends JpaRepository<Amenities, Integer>{

}
