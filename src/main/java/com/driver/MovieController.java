package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully !", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully!",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movieName,@RequestParam("director") String directorName ){
        movieService.createMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("New movie-director pair added successfully!",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = movieService.findMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.findDirector(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMovieByDirectorName(@PathVariable String directorName){
        List<String> movieList = movieService.findMoviesFromDirector(directorName);
        return new ResponseEntity<>(movieList,HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
        public ResponseEntity<List<String>> findAllMovies(){
            List<String> movies = movieService.findAllMovies();
            return new ResponseEntity<>(movies,HttpStatus.CREATED);
        }


    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){
        movieService.deleteDirector(directorName);
        return new ResponseEntity<>(directorName + "removed successfully!",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-director")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirector();
        return new ResponseEntity<>("All directors deleted successfully!",HttpStatus.CREATED);
    }



}
