package com.example.myapplication.model;

public class Movie {
    String title;
    String description;
    String imageUrl;
    int thumbnail;
    String studio;
    String rating;
    String streamingLink;
    int coverPhoto;
    String Director;
    String Type;
    String Rated;

    public Movie(String title, int thumbnail, int coverPhoto, String director, String type, String rated, String description) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
        Director = director;
        Type = type;
        Rated = rated;
        this.description = description;
    }

    public Movie(String title, int thumbnail, int coverPhoto) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public Movie(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }


    public Movie(String title, String description, String imageUrl, int thumbnail, String studio, String rating, String streamingLink) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.thumbnail = thumbnail;
        this.studio = studio;
        this.rating = rating;
        this.streamingLink = streamingLink;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }
}
