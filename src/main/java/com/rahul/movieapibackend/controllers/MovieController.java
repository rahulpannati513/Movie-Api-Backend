package com.rahul.movieapibackend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.movieapibackend.Exceptions.FileExistsException;
import com.rahul.movieapibackend.Service.MovieServices;
import com.rahul.movieapibackend.dto.MovieDto;
import com.rahul.movieapibackend.dto.MoviePageResponse;
import com.rahul.movieapibackend.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    private final MovieServices movieService;

    public MovieController(MovieServices movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add-movie")
    public ResponseEntity<?> addMovieHandler(@RequestPart MultipartFile file,
                                             @RequestPart String movieDto) throws IOException, FileExistsException {
        MovieDto dto = convertToMovieDto(movieDto);
        try {
            MovieDto createdMovie = movieService.addMovie(dto, file);
            return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
        } catch (IOException | FileExistsException e) {
            throw new FileExistsException("File already Exists to upload please upload another file");
        }
    }

    private MovieDto convertToMovieDto(String movieDtoObject) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(movieDtoObject, MovieDto.class);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDto> getMovieHandler(@PathVariable Integer movieId) {
        return new ResponseEntity<>(movieService.getMovie(movieId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDto>> getAllMoviesHandler() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @PutMapping("/update/{movieId}")
    public ResponseEntity<MovieDto> updateMovieHandler(
            @PathVariable Integer movieId,
            @RequestPart MultipartFile file,
            @RequestPart String movieDtoObj) throws IOException {

        if (file.isEmpty()) file = null;
        MovieDto movieDto = convertToMovieDto(movieDtoObj);
        return new ResponseEntity<>(movieService.updateMovie(movieId, movieDto, file), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<String> deleteMovieHandler(@PathVariable Integer movieId) throws IOException {
        return new ResponseEntity<>(movieService.deleteMovie(movieId), HttpStatus.OK);
    }

    @GetMapping("/allMoviesPage")
    public ResponseEntity<MoviePageResponse> getMoviesWithPagination(

            @RequestParam(defaultValue = AppConstants.PAGE_NUMBER,required=false) Integer pageNumber,
            @RequestParam(defaultValue = AppConstants.PAGE_SIZE,required=false) Integer pageSize) {


        return new ResponseEntity<>(movieService.getAllMoviesWithPagination(pageNumber, pageSize), HttpStatus.OK);


    }


    @GetMapping("/allMoviesPageAndSort")
    public ResponseEntity<MoviePageResponse> getMoviesWithPaginationAndSorting(
            @RequestParam(defaultValue = AppConstants.PAGE_NUMBER,required=false) Integer pageNumber,
            @RequestParam(defaultValue = AppConstants.PAGE_SIZE,required=false) Integer pageSize,
            @RequestParam(defaultValue = AppConstants.SORT_BY,required=false) String sortBy,
            @RequestParam(defaultValue = AppConstants.SORT_DIRECTION,required=false) String direction) {

        return new ResponseEntity<>(movieService.getAllMoviesWithPaginationAndSorting(pageNumber, pageSize, sortBy, direction), HttpStatus.OK);
    }
}
