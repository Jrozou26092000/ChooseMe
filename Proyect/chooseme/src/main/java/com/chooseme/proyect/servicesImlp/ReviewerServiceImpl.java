package com.chooseme.proyect.servicesImlp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chooseme.proyect.entities.Reviewer;
import com.chooseme.proyect.repository.ReviewerRepository;
import com.chooseme.proyect.service.ReviewerService;

@Service
public class ReviewerServiceImpl implements ReviewerService {
	
	@Autowired
	ReviewerRepository reviewerRepository;

	@Override
	public List<Reviewer> findAllReviewers() {
		return reviewerRepository.findAll();
	}

	@Override
	public Optional<Reviewer> findReviewerById(int id) {
		Optional<Reviewer> reviewer =reviewerRepository.findById(id);
		return reviewer;
	}

	@Override
	public Reviewer saveReviewer(Reviewer reviewerNew) {
		if (reviewerNew != null) {
			return reviewerRepository.save(reviewerNew);
		}
		return new Reviewer();
	}

	@Override
	public String deleteReviewer(int id) {
		if (reviewerRepository.findById(id).isPresent()) {
			reviewerRepository.deleteById(id);
			return "Reviewer eliminado correctamente.";
		}
		return "Error! El reviewer no existe";
	}

	@Override
	public String updateReviewer(Reviewer reviewerNew) {
		int num = reviewerNew.getId();
		if (reviewerRepository.findById(num).isPresent()) {
			Reviewer reviewerToUpdate = new Reviewer();
			reviewerToUpdate.setId(reviewerToUpdate.getId());
			reviewerToUpdate.setUser_name(reviewerToUpdate.getUser_name());
			reviewerToUpdate.setUser_id(reviewerToUpdate.getUser_id());
			reviewerToUpdate.setReviewer(reviewerToUpdate.getReviewer());
			reviewerRepository.save(reviewerToUpdate);
			return " Reviewer odificado";
		}
		return "Error al modificar el Reviewer";
	}

	
}
