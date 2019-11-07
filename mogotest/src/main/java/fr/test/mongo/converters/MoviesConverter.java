package fr.test.mongo.converters;

import com.mongodb.client.FindIterable;
import fr.test.mongo.modele.Movie;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MoviesConverter {

    public Movie convertDocumentToMovie(final Document document) {
        Movie movie = new Movie();
        movie.setTitle((String) document.get("title"));
        movie.setYear((String)document.get("year"));
        movie.setGenres((ArrayList<String>) document.get("genres"));
        return movie;
    }


    public List<Movie> convertDocumentsToMovies(final FindIterable<Document> documents) {
        List<Movie> movies = new ArrayList<Movie>();
        for (Document doc : documents) {
            movies.add(convertDocumentToMovie(doc));
        }
        return movies;
    }
}
