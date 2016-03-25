package com.androidbelieve.drawerwithswipetabs.model;

import java.util.ArrayList;

/**
 * Created by Anshul on 23-03-2016.
 */
import java.util.ArrayList;

public class Movie {
    private String title, thumbnailUrl;
    private int price;
    private double tag;
    private ArrayList<String> genre;

    public Movie() {
    }

    public Movie(String name, String thumbnailUrl, int price, double tag,
                 ArrayList<String> genre) {
        this.title = name;
        this.thumbnailUrl = thumbnailUrl;
        this.price = price;
        this.tag = tag;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTag() {
        return tag;
    }

    public void setTag(double tag) {
        this.tag = tag;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

}
