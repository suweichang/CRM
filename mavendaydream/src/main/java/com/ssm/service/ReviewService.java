package com.ssm.service;

import com.ssm.pojo.Review;

import java.util.List;

public interface ReviewService {
    List<Review> GetAllReview();
    Integer AddReview(Review review);
    Review GetReviewById(int review_id);
    Integer ChangReviewStatus(int review_id);
}
