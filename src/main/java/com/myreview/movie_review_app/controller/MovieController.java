package com.myreview.movie_review_app.controller;

import com.myreview.movie_review_app.dto.MovieRequest;
import com.myreview.movie_review_app.dto.MovieResponse;
import com.myreview.movie_review_app.entity.Movie;
import com.myreview.movie_review_app.enums.Genre;
import com.myreview.movie_review_app.service.MovieService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // SEARCH ABOUT A PARTICULAR MOVIE
    @GetMapping("/title/{title}")
    public MovieResponse getMovieByTile(@PathVariable String title){
        return (movieService.getByTile(title)).toMovieResponse();
    }

    // SEARCH MOVIE BY GENRE

    @GetMapping("/genre/{genre}")
    public List<MovieResponse> getMovie(@PathVariable String genre){
        return movieService.showByGenre(genre);
    }




}
