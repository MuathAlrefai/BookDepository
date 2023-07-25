package com.axsos.bookdepository.services;


import com.axsos.bookdepository.models.Review;
import com.axsos.bookdepository.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(Review review){
        return reviewRepository.save(review);
    }

    public Review updateReview(Review review){
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id){
        reviewRepository.deleteById(id);
    }

    public List<Review> allReviews(){
        return reviewRepository.findAll();
    }

    public Review findReview(Long id){
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent()){
            return optionalReview.get();
        }else {
            return null;
        }
    }
}
