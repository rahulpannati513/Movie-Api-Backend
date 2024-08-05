package com.rahul.movieapibackend.Service;

import com.rahul.movieapibackend.Exceptions.FileExistsException;
import com.rahul.movieapibackend.dto.MovieDto;
import com.rahul.movieapibackend.dto.MoviePageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MovieServices
{
    MovieDto addMovie(MovieDto movieDto, MultipartFile file) throws IOException, FileExistsException;

    MovieDto getMovie(Integer movieId);

    List<MovieDto> getAllMovies();

    MovieDto updateMovie(Integer movieId, MovieDto movieDto,MultipartFile file)throws IOException;

    String deleteMovie(Integer movieId) throws IOException;

    MoviePageResponse getAllMoviesWithPagination(Integer pageNumber,Integer pageSize);

    MoviePageResponse getAllMoviesWithPaginationAndSorting(Integer pageNumber,Integer pageSize,String sortBy,String direction);

}
