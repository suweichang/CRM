package com.ssm.service.impl;

import com.ssm.dao.ReviewDao;
import com.ssm.pojo.Review;
import com.ssm.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewDao reviewDao;
    @Override
    public List<Review> GetAllReview() {
        return reviewDao.GetAllReview();
    }

    @Override
    public Integer AddReview(Review review) {
        return reviewDao.AddReview(review);
    }

    @Override
    public Review GetReviewById(int review_id) {
        return reviewDao.GetReviewById(review_id);
    }

    @Override
    public Integer ChangReviewStatus(int review_id) {
        return reviewDao.ChangReviewStatus(review_id);
    }
}
