package fr.mongo.services;

import com.mongodb.client.FindIterable;
import fr.mongo.modele.AssociationUserMovie;
import fr.mongo.modele.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    public static  List<User> convertList(FindIterable<Document> docs){
        List<User> users = new ArrayList<User>();
        for (Document doc : docs) {
            User user = convert(doc);
            users.add(user);
        }
        return users;
    }


    public static User convert(Document document){
        User user = new User();
        user.setId((Integer) document.get("_id") + "");
        user.setAge((Integer) document.get("age"));
        user.setGender((String) document.get("gender"));
        user.setName((String) document.get("name"));
        user.setOccupation((String) document.get("occupation"));
        List<Document> movies = (ArrayList<Document>)document.get("movies");
        List<AssociationUserMovie> associationUserMovies = MovieConverter.convertList(movies);
        user.setMovies(associationUserMovies);

        return user;
    }
}
