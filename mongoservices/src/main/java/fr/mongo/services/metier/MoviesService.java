package fr.mongo.services.metier;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import fr.mongo.modele.AssociationUserMovie;
import fr.mongo.modele.Movie;
import fr.mongo.services.MongoConnectionService;
import fr.mongo.services.MovieConverter;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class MoviesService {

    private MongoClient clientdb;
    private MongoDatabase database;


    public MoviesService() {
        clientdb = MongoConnectionService.getConnection("localhost", 27017);
        database = clientdb.getDatabase("movies-db");
    }

    public List<Movie> findByGenre(final String genre) {
        BsonDocument request = new BsonDocument();
        List<BsonString> genres = Arrays.asList(new BsonString(genre));
        request.append("genres", new BsonArray(genres));
        FindIterable<Document> movies = database.getCollection("movies").find(request);
        return MovieConverter.convertList(movies);
    }


    public List<Movie> findByTitle(final String title) {
        BsonDocument request = new BsonDocument();
        request.append("title", new BsonString(title));
        FindIterable<Document> movies = database.getCollection("movies").find(request);
        return MovieConverter.convertList(movies);
    }

    public void addMovie(Movie movie) {
        Document document = new Document();
        document.put("title", movie.getTitle());
        document.put("genres", movie.getGenres());
        database.getCollection("movies").insertOne(document);
    }

    public void deleteMovie(String title) {
        Document document = new Document();
        document.put("title", title);
        database.getCollection("movies").deleteMany(document);
    }


    public List<Movie> findAll() {
        FindIterable<Document> moviesDOC = database.getCollection("movies")
                .find();
        return MovieConverter.convertList(moviesDOC);
    }


}
