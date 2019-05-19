package com.reviewrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewrestapi.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
