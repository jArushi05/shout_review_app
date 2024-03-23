package com.myreview.movie_review_app.dto;

import com.myreview.movie_review_app.entity.Movie;
import com.myreview.movie_review_app.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class MovieRequest {
    private String title;
    private Genre genre;

    public Movie toMovie(){
        Movie movie = Movie.builder()
                .title(title)
                .genre(genre)
                .rating(0.0)
                .build();

        return movie;
    }

}
