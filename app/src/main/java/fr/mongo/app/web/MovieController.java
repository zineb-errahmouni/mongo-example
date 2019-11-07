package fr.mongo.app.web;

import fr.mongo.app.modele.Movie;
import fr.mongo.app.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MoviesService service;

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return service.getAllMovies();
    }


}
