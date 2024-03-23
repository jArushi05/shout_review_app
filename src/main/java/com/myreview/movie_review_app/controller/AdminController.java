package com.myreview.movie_review_app.controller;

import com.myreview.movie_review_app.dto.MovieRequest;
import com.myreview.movie_review_app.dto.MovieResponse;
import com.myreview.movie_review_app.entity.Movie;
import com.myreview.movie_review_app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    // ADMIN WILL ADD THE MOVIES TO MY DATABASE
    @PostMapping("/movie/add")
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest){
     return ResponseEntity.ok(adminService.addMovie(movieRequest.toMovie()));
    }


}
