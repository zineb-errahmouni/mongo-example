package fr.mongo.app.data;

import fr.mongo.app.modele.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
