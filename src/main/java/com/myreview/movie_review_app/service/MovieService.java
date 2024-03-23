package com.myreview.movie_review_app.service;

import com.myreview.movie_review_app.dao.MovieDao;
import com.myreview.movie_review_app.dto.MovieResponse;
import com.myreview.movie_review_app.entity.Movie;
import com.myreview.movie_review_app.enums.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieDao movieDao;
    public Movie getByTile(String title) {
        return movieDao.findByTitle(title);
    }

    public List<MovieResponse> showByGenre(String genre) {
       List<Movie> list = movieDao.findByGenre(Genre.valueOf(genre));
//        System.out.println(list);
      List<MovieResponse> movieList = list.stream()
              .sorted(Comparator.comparing(Movie::getRating, Comparator.reverseOrder()))
              .map(x->x.toMovieResponse())
              .collect(Collectors.toList());
//        System.out.println(movieList);.
      return movieList;
    }
}
