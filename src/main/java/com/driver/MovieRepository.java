package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

    private HashMap<String,Movie> movieHashMap;
    private HashMap<String,Director> directorHashMap;
    private HashMap<String, List<String>> directorMoviePair;


    public MovieRepository(){
        this.movieHashMap=new HashMap<>();
        this.directorHashMap= new HashMap<>();
        this.directorMoviePair=new HashMap<>();
    }
    public void addMovieToMap(Movie mv){
        movieHashMap.put(mv.getName(),mv);

    }

    public void addDirectorToMap(Director di){
        directorHashMap.put(di.getName(),di);
    }

    public void addDirectorMoviePairToMap(String movieName,String directorName){

        if(movieHashMap.containsKey(movieName) && directorHashMap.containsKey(directorName)){
            List<String> allMoviesByDirector = new ArrayList<>();

            if(directorMoviePair.containsKey(directorName)) {
                allMoviesByDirector = directorMoviePair.get(directorName);
            }
                allMoviesByDirector.add(movieName);

                directorMoviePair.put(directorName,allMoviesByDirector);
        }
    }

    public Movie searchMovie(String movieName){
        return movieHashMap.get(movieName);
    }

    public Director searchDirector(String directorName){
        return directorHashMap.get(directorName);
    }

    public List<String> getListOfMoviesFromDirector(String directorName){

        List<String> moviesFromDirectorList = new ArrayList<>();
        if(directorMoviePair.containsKey(directorName))
            moviesFromDirectorList=directorMoviePair.get(directorName);
        return moviesFromDirectorList;
    }
    public List<String> getListOfAllMovies(){
        List<String> allMovieList = new ArrayList<>(movieHashMap.keySet());
        return allMovieList;
    }

    public void deleteDirectorAndMovie(String directorName){

        List<String> directorsMovies = new ArrayList<>();

        if(directorMoviePair.containsKey(directorName)) {
            directorsMovies = directorMoviePair.get(directorName);

            for (String movie : directorsMovies) {
                if (movieHashMap.containsKey(movie)) {
                    movieHashMap.remove(movie);
                }
            }
        }

        if(directorHashMap.containsKey(directorName)){
            directorHashMap.remove(directorName);
        }
    }

    public void deleteAllDirectors(){
        HashSet<String> moviesSet = new HashSet<>();

        directorHashMap = new HashMap<>();

        for(String directorName: directorMoviePair.keySet()){
            for(String movieName: directorMoviePair.get(directorName)){
                moviesSet.add(movieName);
            }
        }

        for(String movieName: moviesSet){
            if(movieHashMap.containsKey(movieName)){
                movieHashMap.remove(movieName);
            }
        }

        directorMoviePair = new HashMap<>();


    }







}
