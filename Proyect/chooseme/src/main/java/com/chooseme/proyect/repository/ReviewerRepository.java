package com.chooseme.proyect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chooseme.proyect.entities.Reviewer;	

public interface ReviewerRepository  extends JpaRepository<Reviewer, Integer>{
	
	Void save(Optional<Reviewer> reviewerToUpdate);
}
