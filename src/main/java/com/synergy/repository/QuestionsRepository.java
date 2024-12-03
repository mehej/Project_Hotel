package com.synergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.synergy.domain.Questions;
@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Integer>{
	
	

}
