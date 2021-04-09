package com.chooseme.proyect.controllers;


import java.util.List;
import java.util.Optional;
import com.chooseme.proyect.entities.Reviewer;

public interface ReviewerController {
	public List<Reviewer> getReviewers();

	public Optional<Reviewer> getReviewerById(int id);

	public Reviewer addReviewer(Reviewer reviewer);

	public String deleteReviewer(int id);

	public String updateReviewer(Reviewer reviewerNew);

	public String test();
}