package com.leoscode.moviecatalogservice.model;

import java.util.Objects;

public class CatalogItem {

private String userId;
private String desc;
private  int rating;

    public CatalogItem(String userId, String desc, int rating) {
        this.userId = userId;
        this.desc = desc;
        this.rating = rating;
    }

    public CatalogItem() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
