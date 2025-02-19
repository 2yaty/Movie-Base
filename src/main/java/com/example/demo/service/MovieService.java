package com.example.demo.service;


import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Page<Movie> getAllMovies(Pageable pageable){

        return movieRepository.findAll(PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.DESC, "title"))));
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }


    public List<Movie> searchMovies(String title, Integer year, String genre) {
        if (title != null && !title.isEmpty()) {
            return movieRepository.searchByTitle(title);
        } else if (year != null) {
            return movieRepository.findByYear(year);
        } else if (genre != null && !genre.isEmpty()) {
            return movieRepository.findByGenreContainingIgnoreCase(genre);
        }
        return movieRepository.findAll();
    }

    @Transactional
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Transactional
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}