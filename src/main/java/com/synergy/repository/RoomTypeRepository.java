package com.synergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.synergy.domain.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

}
