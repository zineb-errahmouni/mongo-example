package fr.mongo.modele;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String gender;
    private String name;
    private int age;
    private String occupation;
    private List<AssociationUserMovie> movies;

    public User(){
        movies = new ArrayList<AssociationUserMovie>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setMovies(List<AssociationUserMovie> movies) {
        this.movies = movies;
    }

    public List<AssociationUserMovie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                ", movies=" + movies +
                '}';
    }
}
