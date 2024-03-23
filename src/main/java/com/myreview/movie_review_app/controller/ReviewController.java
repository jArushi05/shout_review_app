package com.myreview.movie_review_app.controller;

import com.myreview.movie_review_app.dto.ReviewRequest;
import com.myreview.movie_review_app.dto.ReviewResponse;
import com.myreview.movie_review_app.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
//     TO GIVE REVIEWS TO A MOVIE

    @PostMapping("/givereview")
    public void myReview(@RequestBody ReviewRequest reviewRequest) {

        reviewService.add(reviewRequest.toReview());
    }

    //    GET MOVIE REVIEWS BY ID;
    @GetMapping("/find/{reviewId}")
    public ReviewResponse getReview(@PathVariable Long reviewId) {

        return reviewService.getReviewById(reviewId);
    }
}