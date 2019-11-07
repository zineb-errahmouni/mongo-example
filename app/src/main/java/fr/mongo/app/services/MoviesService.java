package fr.mongo.app.services;

import fr.mongo.app.data.MovieRepository;
import fr.mongo.app.modele.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MovieRepository repository;

    /**
     * MovieService service = new MovieService();
     * MovieRepository repo = new MovieRepository();
     * service.setRepo(repo);
     *
     * @return
     */

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }


}
