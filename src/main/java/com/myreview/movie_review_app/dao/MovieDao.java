package com.myreview.movie_review_app.dao;

import com.myreview.movie_review_app.entity.Movie;
import com.myreview.movie_review_app.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDao extends JpaRepository<Movie,Long> {
    public Movie findByTitle(String title);

    public List<Movie> findByGenre(Genre genre);
}
