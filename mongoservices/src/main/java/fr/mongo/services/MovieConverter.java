package fr.mongo.services;

import com.mongodb.client.FindIterable;
import fr.mongo.modele.AssociationUserMovie;
import fr.mongo.modele.Movie;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class MovieConverter {

    public static List<AssociationUserMovie> convertList(List<Document> docs) {
        List<AssociationUserMovie> list = new ArrayList<AssociationUserMovie>();
        for (Document doc : docs) {
            AssociationUserMovie assoc = new AssociationUserMovie();
            assoc.setMovieid((Integer) doc.get("movieid"));
            assoc.setRating((Integer) doc.get("rating"));
            list.add(assoc);
        }
        return list;
    }

    public static List<Movie> convertList(FindIterable<Document> docs) {
        List<Movie> list = new ArrayList<Movie>();
        for (Document doc : docs) {
            list.add(convert(doc));
        }
        return list;
    }

    public static Movie convert(Document doc) {
        Movie movie = new Movie();
        if (doc.get("_id") instanceof ObjectId) {
            ObjectId id = (ObjectId) doc.get("_id");
            movie.setId(id.toString());
        } else {
            Integer id = (Integer) doc.get("_id");
            movie.setId(id.toString());
        }

        movie.setTitle((String) doc.get("title"));
        movie.setGenres((ArrayList<String>) doc.get("genres"));
        return movie;
    }
}
