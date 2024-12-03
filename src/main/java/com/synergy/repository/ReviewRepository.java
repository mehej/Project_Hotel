package com.synergy.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.databind.JsonNode;
import com.synergy.domain.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {

  public List<Review> findByHotelId(int hotelid);

}
