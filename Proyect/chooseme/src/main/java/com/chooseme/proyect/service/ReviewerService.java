package com.chooseme.proyect.service;

import java.util.List;
import java.util.Optional;
import com.chooseme.proyect.entities.Reviewer;

public interface ReviewerService {
	public List<Reviewer> findAllReviewers();
	
	public Optional<Reviewer> findReviewerById(int id);
	
	public Reviewer saveReviewer(Reviewer reviewerNew);
	
	public String deleteReviewer(int id);
	
	public String updateReviewer(Reviewer reviewerNew);
}
