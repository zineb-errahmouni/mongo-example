package fr.mongo.services.metier;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import fr.mongo.modele.User;
import fr.mongo.services.MongoConnectionService;
import fr.mongo.services.UserConverter;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.BsonNumber;
import org.bson.Document;

import java.util.List;

public class UserService {

    private MongoClient clientdb;
    private MongoDatabase database;


    public UserService() {
        clientdb = MongoConnectionService.getConnection("localhost",27017);
        database = clientdb.getDatabase("movies-db");
    }

    public List<User> findAllMovieByUserID(String id){
        BsonNumber bsonObjectId= new BsonInt64(Long.parseLong(id));
        BsonDocument document  = new BsonDocument();
        document.append("_id", bsonObjectId);
        FindIterable<Document> users = database.getCollection("users").find(document);
        return UserConverter.convertList(users);
    }



    public static void main(String[] args) {
        UserService user = new UserService();
        List<User> allMovieByUserID = user.findAllMovieByUserID("6038");
        System.out.println(allMovieByUserID);
    }



}
