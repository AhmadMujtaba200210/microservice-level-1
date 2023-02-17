package io.microservices.ratingdataservice.model;

import java.util.List;

public class UserRating {
    private List<Ratings> userRating;

    public List<Ratings> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Ratings> userRating) {
        this.userRating = userRating;
    }
}
