package fr.test.mongo.config;

import com.mongodb.MongoClient;

public class MongoConfig {

    private static MongoClient mongoClient;

    public static MongoClient getClient(String host, int port) {
        if (mongoClient == null) {
            mongoClient = new MongoClient(host, port);
        }
        return mongoClient;
    }

}
