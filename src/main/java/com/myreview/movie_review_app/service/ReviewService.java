package com.myreview.movie_review_app.service;

import com.myreview.movie_review_app.dao.MovieDao;
import com.myreview.movie_review_app.dao.ReviewDao;
import com.myreview.movie_review_app.dto.ReviewResponse;
import com.myreview.movie_review_app.entity.Movie;
import com.myreview.movie_review_app.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private MovieDao movieDao;
    public void add(Review review) {

        Movie movie=movieDao.findById(review.getMovie().getId()).orElse(null);
        reviewDao.save(review);
        //need to optimized
        //exception handling.
        if(movie!=null) {
            Double average = reviewDao.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieDao.save(movie);
        }
    }

    public ReviewResponse getReviewById(Long reviewId) {


       Optional<Review>review= reviewDao.findById(reviewId);
        return review.map(Review::toReviewResponse).orElse(null);

//        return review
//        review.stream().

    }




}
