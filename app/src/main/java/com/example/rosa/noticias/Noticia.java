package com.example.rosa.noticias;

import java.io.Serializable;

public class Noticia implements Serializable {
private int id;
private String title;
private String urlToImage;
private String author;
private String description;
private String publishedAt;

    public Noticia() {
    }

    public Noticia(String title, String urlToImage, String description, String publishedAt) {
        this.title = title;
        this.urlToImage = urlToImage;
        this.description = description;
        this.publishedAt = publishedAt;
    }

    public Noticia(String title, String urlToImage, String author, String description, String publishedAt) {
        this.title = title;
        this.urlToImage = urlToImage;
        this.description = description;
        this.publishedAt = publishedAt;
        this.author = author;
    }

    public Noticia(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getAutor() {
        return author;
    }

    public void setAutor(String autor) {
        this.author = autor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", autor='" + author + '\'' +
                ", description='" + description + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
