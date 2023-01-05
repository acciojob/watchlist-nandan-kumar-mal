package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepo;

    public void addMovie(Movie movie){
        movieRepo.addMovieToMap(movie);
    }

    public void addDirector(Director director){
        movieRepo.addDirectorToMap(director);
    }

    public void createMovieDirectorPair(String movie,String director){
        movieRepo.addDirectorMoviePairToMap(movie,director);
    }

    public Movie findMovie(String movieName){
        return movieRepo.searchMovie(movieName);
    }

    public Director findDirector(String directorName){
        return movieRepo.searchDirector(directorName);
    }

    public String findDirectorFromMovieName(String movieName){
        return movieRepo.searchDirectorFromMovieName(movieName);
    }
    public List<String> findMoviesFromDirector(String directorName){
        return movieRepo.getListOfMoviesFromDirector(directorName);
    }

    public List<String> findAllMovies(){
        return movieRepo.getListOfAllMovies();
    }

    public void deleteDirector(String directorName){
        movieRepo.deleteDirectorAndMovie(directorName);
    }

    public void deleteAllDirector(){
        movieRepo.deleteAllDirectors();
    }
}
