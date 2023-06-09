package src.com.certifications.javase11.chapter13IOApi.project.prod;

import java.io.Serializable;

public enum Rating implements Serializable {

    //Enumerations are implicitly public static and final
    NOT_RATED("\u2606\u2606\u2606\u2606\u2606"),
    ONE_STAR("\u2605\u2606\u2606\u2606\u2606"),
    TWO_STAR("\u2605\u2605\u2606\u2606\u2606"),
    THREE_STAR("\u2605\u2605\u2605\u2606\u2606"),
    FOUR_STAR("\u2605\u2605\u2605\u2605\u2606"),
    FIVE_STAR("\u2605\u2605\u2605\u2605\u2605");

    private String stars;

    public String getStars() {
        return stars;
    }

    private Rating(String stars) {
        this.stars=stars;
    }
}
