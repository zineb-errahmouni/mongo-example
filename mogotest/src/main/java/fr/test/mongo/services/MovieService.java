package fr.test.mongo.services;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.test.mongo.config.MongoConfig;
import fr.test.mongo.converters.MoviesConverter;
import fr.test.mongo.modele.Movie;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MovieService {

    private MoviesConverter converter = new MoviesConverter();
    private MongoClient mongoClient = MongoConfig.getClient("localhost", 27017);

    /**
     * recupére une liste de movies
     * @return
     */
    public List<Movie> getAllMovies() {
        MongoDatabase database = mongoClient.getDatabase("movies-db");
        MongoCollection<Document> collectionMovies = database.getCollection("movies");
        FindIterable<Document> documents = collectionMovies.find();
        return converter.convertDocumentsToMovies(documents);
    }

    public List<Movie> getMoviesByTitle(final String title){
        MongoDatabase database = mongoClient.getDatabase("movies-db");
        FindIterable<Document> movieTitle = database.getCollection("movies").find(eq("title", title));
        return converter.convertDocumentsToMovies(movieTitle);
    }


}
