package com.reviewrestapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewrestapi.model.Review;
import com.reviewrestapi.repository.ReviewRepository;

@Service
public class ReviewDAO {

	@Autowired
	ReviewRepository reviewRepository;
	
	public Review save(Review r) {
		return reviewRepository.save(r);
	}
	
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}
	
	public Optional<Review> findOne(Long rid) {
		return reviewRepository.findById(rid);
	}
	
	public void delete(Review r) {
		reviewRepository.delete(r);
	}
	
}
