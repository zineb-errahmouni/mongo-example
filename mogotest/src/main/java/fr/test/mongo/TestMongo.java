package fr.test.mongo;

import fr.test.mongo.modele.Movie;
import fr.test.mongo.services.MovieService;

import java.util.List;

public class TestMongo {

    public static void getMoviesByTitleTest(){
        MovieService service = new MovieService();
        List<Movie> movieTitle = service.getMoviesByTitle("Toy Story ");
        //System.out.println(movieTitle);
        List<Movie> moviesByTitle = service.getMoviesByTitle("Waiting to Exhale (1995)");
        System.out.println(moviesByTitle);

    }


    public static void main(String[] args) {
        getMoviesByTitleTest();
    }

}
