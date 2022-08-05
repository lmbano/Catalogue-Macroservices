package com.leoscode.movieinfoservice.model;

public class MovieSummary {

    private String title;
    private String overView;

    public MovieSummary() {
    }

    public MovieSummary(String title, String overView) {
        this.title = title;
        this.overView = overView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }
}
