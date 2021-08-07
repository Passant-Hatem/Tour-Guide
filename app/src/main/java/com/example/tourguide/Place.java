package com.example.tourguide;

public class Place {
    String name;
    String details;
    int imageSource;

    public Place(String name, int imageSource, String details) {
        this.name = name;
        this.imageSource = imageSource;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public int getImageSource() {
        return imageSource;
    }

    public String getDetails() {
        return details;
    }
}
