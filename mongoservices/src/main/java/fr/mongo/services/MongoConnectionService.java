package fr.mongo.services;

import com.mongodb.MongoClient;
import fr.mongo.modele.Movie;
import fr.mongo.services.metier.MoviesService;

import java.util.Arrays;
import java.util.List;

public class MongoConnectionService {


    private static MongoClient db;


   public static MongoClient getConnection(final String host, final int port){
        if(db == null) {
            db = new MongoClient(host, port);
        }
        return db;
    }

    public static void main(String[] args) {
        testMovieService();
    }

    public static void testMovieService(){
        MoviesService service = new MoviesService();
        List<Movie> movies = service.findAll();
        System.out.println("sss" + movies);
        List<Movie> moviesComedie = service.findByGenre("Comedy");
        System.out.println("comedie: " + moviesComedie);
        List<Movie> byName = service.findByTitle("Scarlet Letter, The (1995)");
        System.out.println("name: " + byName);
        Movie movie = new Movie();
        movie.setTitle("Aladin");
        movie.setGenres(Arrays.asList("Comedy","adventure"));
        service.addMovie(movie);
        List<Movie> films = service.findByTitle("Aladin");
        System.out.println("name: " + films);
        service.deleteMovie("Aladin");
        films = service.findByTitle("Aladin");
        System.out.println("name: " + films);
    }


    public void closeConnecion(){
        db.close();
    }

}
