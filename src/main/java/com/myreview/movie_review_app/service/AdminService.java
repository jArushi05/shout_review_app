package com.myreview.movie_review_app.service;


import com.myreview.movie_review_app.dao.MovieDao;
import com.myreview.movie_review_app.dto.MovieRequest;
import com.myreview.movie_review_app.dto.MovieResponse;
import com.myreview.movie_review_app.entity.Movie;
import com.myreview.movie_review_app.enums.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private MovieDao movieDao;

    public MovieResponse addMovie(Movie movie) {
        movie=movieDao.save(movie);
       return movie.toMovieResponse();

    }
}
