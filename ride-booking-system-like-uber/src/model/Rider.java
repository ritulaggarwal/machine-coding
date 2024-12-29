package model;

import enums.Rating;

public class Rider {

    private String id;
    private String name;
    private Rating rating;

    public Rider(String id, String name) {
        this.id = id;
        this.name = name;
        this.rating = Rating.UNASSIGNED;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
