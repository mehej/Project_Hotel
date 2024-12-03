package com.synergy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reviewId;
	private String comments;
	private double ratings;
	private int hotelId;
	private int bookingId;
	private String username;
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewId, String comments, double ratings, int hotelId, int bookingId,String username) {
		super();
		this.reviewId = reviewId;
		this.setComments(comments);
		this.ratings = ratings;
		this.hotelId = hotelId;
		this.bookingId = bookingId;
		this.username=username;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}