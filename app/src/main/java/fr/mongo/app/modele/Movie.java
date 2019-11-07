package fr.mongo.app.modele;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "movies")
@Getter
@Setter
public class Movie {

    private String title;
    private String year;
    private List<String> genres;

}
