package com.reviewrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewrestapi.dao.ReviewDAO;
import com.reviewrestapi.model.Review;

@RestController
@RequestMapping("/products")
public class ReviewController {

	@Autowired
	ReviewDAO dao;
//	create
	@PostMapping("/reviews")
	public Review createReview(@Valid @RequestBody Review r) {
		return dao.save(r);
	}

	@GetMapping("/reviews")
	public List<Review> getAllReviews(){
		return dao.findAll();
	}
	
	@GetMapping("/reviews/{id}")
	public  ResponseEntity<Review> getEmployeeId(@PathVariable(value="id") Long empId){
		
		Review emp = dao.findOne(empId).orElse(null);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	//Update an Employee using ID
	@PutMapping("/reviews/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable(value="id") long empId,@Valid @RequestBody Review empDetails){
		
		Review emp = dao.findOne(empId).orElse(null);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setProId(empDetails.getProId());
		emp.setTitle(empDetails.getTitle());
		emp.setFeedback(empDetails.getFeedback());
		
		Review updateReview = dao.save(emp);
		return ResponseEntity.ok().body(updateReview);
	}
	
	//Delete an Employee
	@DeleteMapping("/reviews/{id}")
	public ResponseEntity<Review> deleteEmployee(@PathVariable(value="id") Long empId){
		
		Review emp = dao.findOne(empId).orElse(null);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}	
		dao.delete(emp);
		return ResponseEntity.ok().build();
	}
}
	
	
