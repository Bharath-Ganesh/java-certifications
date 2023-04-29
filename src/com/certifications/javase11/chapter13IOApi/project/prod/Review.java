package src.com.certifications.javase11.chapter13IOApi.project.prod;

import java.io.Serializable;

//6. Implements Comparable interface using in the Review class
/*
Override the comparable interface compareTo()
 */
public class Review implements Comparable<Review>, Serializable {

    private Rating rating;
    private String comments;

    public Review(Rating rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }

    public Rating getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }

    @Override
    public int compareTo(Review other) {
        return other.getRating().ordinal()-this.getRating().ordinal();
    }
}
