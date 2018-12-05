package com.ssm.dao;

import com.ssm.pojo.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewDao {
    List<Review> GetAllReview();
    Integer AddReview(Review review);
    Review GetReviewById(int review_id);
    Integer ChangReviewStatus(@Param("review_id") int review_id);
}
