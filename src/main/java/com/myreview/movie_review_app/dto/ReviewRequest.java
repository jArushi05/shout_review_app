package com.myreview.movie_review_app.dto;

import com.myreview.movie_review_app.entity.Movie;
import com.myreview.movie_review_app.entity.Review;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReviewRequest {

    private String movieReview;
    private Double rating;
    private Long movieId;


    public Review toReview(){
        return Review.builder()
                .movieReview(movieReview)
                .rating(rating)
                .movie(Movie.builder()
                        .id(movieId)
                        .build())
                .build();
    }

}
