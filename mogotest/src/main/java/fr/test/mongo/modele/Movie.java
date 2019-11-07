package fr.test.mongo.modele;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Movie {

    private String title;
    private List<String> genres;
    private String year;

}
