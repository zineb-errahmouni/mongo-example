package fr.mongo.modele;

public class AssociationUserMovie {

    private Integer movieid;
    private Integer rating;
    private String timestamp;


    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRating() {
        return rating;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "AssociationUserMovie{" +
                "movieid=" + movieid +
                ", rating=" + rating +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
