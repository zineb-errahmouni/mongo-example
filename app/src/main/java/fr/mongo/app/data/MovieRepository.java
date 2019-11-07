package fr.mongo.app.data;

import fr.mongo.app.modele.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByTitle(String titre);
}
