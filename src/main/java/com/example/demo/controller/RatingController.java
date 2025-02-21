package com.example.demo.controller;


import com.example.demo.dto.RatingRequest;
import com.example.demo.entity.Rating;
import com.example.demo.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
@CrossOrigin
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Rating> rateMovie(@RequestBody RatingRequest request, Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(ratingService.rateMovie(request, username));
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<List<Rating>> getMovieRatings(@PathVariable Long movieId) {
        return ResponseEntity.ok(ratingService.getMovieRatings(movieId));
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<String> deleteRating(@PathVariable Long ratingId, Authentication authentication) {
        String username = authentication.getName();
        ratingService.deleteRating(ratingId, username);
        return ResponseEntity.ok("Rating deleted successfully");
    }
}
