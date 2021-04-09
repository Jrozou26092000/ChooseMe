package com.chooseme.proyect.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.chooseme.proyect.controllers.ReviewerController;
import com.chooseme.proyect.entities.Reviewer;
import com.chooseme.proyect.service.ReviewerService;

@RestController
public class ReviewerControllerImpl implements ReviewerController {
	@Autowired
	ReviewerService reviewerService;

	// http://localhost:8888/reviewers (GET)
	@RequestMapping(value = "/reviewers", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Reviewer> getReviewers() {
		return reviewerService.findAllReviewers();
	}

	// http://localhost:8888/reviewers/1 (GET)
	@Override
	@RequestMapping(value = "/reviewers/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Reviewer> getReviewerById(@PathVariable int id) {
		return reviewerService.findReviewerById(id);
	}

	// http://localhost:8888/reviewers/add (ADD)
	@Override
	@RequestMapping(value = "/reviewers/add", method = RequestMethod.POST, produces = "application/json")
	public Reviewer addReviewer(Reviewer reviewer) {
		return reviewerService.saveReviewer(reviewer);
	}

	// http://localhost:8888/reviewers/delete/1 (GET)
	@Override
	@RequestMapping(value = "/reviewers/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteReviewer(@PathVariable int id) {
		return reviewerService.deleteReviewer(id);
	}

	// http://localhost:8888/reviewers/update (PATCH)
	@Override
	@RequestMapping(value = "/reviewers/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateReviewer(Reviewer reviewerNew) {
		return reviewerService.updateReviewer(reviewerNew);
	}

	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}
}