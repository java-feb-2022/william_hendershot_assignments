package com.codingdojo.books_api.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=5, max = 255)
    private String title;
    
    @NotNull
    @Size(min=5, max = 255)
    private String description;

    @NotNull
    @Size(min=3, max = 255)
    private String language;

    @NotNull
    @Min(100)
    private Integer num_of_pages;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created_at;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updated_at;

    public Book() {}

    public Book(String title, String description, String language, int pages){
        this.title = title;
        this.description = description;
        this.language = language;
        this.num_of_pages = pages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getNum_of_pages() {
        return num_of_pages;
    }

    public void setNum_of_pages(Integer num_of_pages) {
        this.num_of_pages = num_of_pages;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date update_at) {
        this.updated_at = update_at;
    }

    @PrePersist
    protected void onCreate() {
        this.created_at = new Date();
        this.updated_at = this.created_at;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = new Date();
    }

    @Override
    public String toString() {
        String result = "";
        result += String.format("Id: %s%n", id);
        result += String.format("Title: %s%n", title);
        result += String.format("Description: %s%n", description);
        result += String.format("Language: %s%n", language);
        result += String.format("Number of pages: %d%n", num_of_pages);
        result += String.format("Created at: %s%n", created_at);
        result += String.format("Updated at: %s%n", updated_at);
        return result;
    }
}
