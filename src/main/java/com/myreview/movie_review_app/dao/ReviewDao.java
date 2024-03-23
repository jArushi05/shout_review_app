package com.myreview.movie_review_app.dao;

import com.myreview.movie_review_app.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewDao  extends JpaRepository<Review, Long> {

    @Query(value = "select avg(rating) from review where movie_id=?",nativeQuery = true)
    Double getReviewAverage(Long id);
}
