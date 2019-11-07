package fr.mongo.app.modele;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "users")
@Getter
@Setter
public class User {

    @Id
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "gender")
    private String gender;

    @Field(value = "age")
    private Integer age;

    @Field(value = "occupation")
    private String occupation;

    @Field(value = "movies")
    private List<ViewedMovie> viewedMovieList;

}
