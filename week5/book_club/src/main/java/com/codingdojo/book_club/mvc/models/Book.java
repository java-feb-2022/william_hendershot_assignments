package com.codingdojo.book_club.mvc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="created_at", updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @Column(name = "updated_at")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    @NotBlank
    @Size(min = 3, max = 255, message = "Book title must be between 3 and 255 characters")
    private String title;

    @NotBlank
    @Size(min = 3, max = 255, message = "Book author's name must be between 3 and 255 characters")
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posted_by_user_id")
    private User user;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BookThought> bookThoughts;

    public Book() {}

    public Book(
            @NotBlank @Size(min = 3, max = 255, message = "Book title must be between 3 and 255 characters") String title,
            @NotBlank @Size(min = 3, max = 255, message = "Book author's name must be between 3 and 255 characters") String author) {
        this.title = title;
        this.author = author;
    }


    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate()
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BookThought> getBookThoughts() {
        return bookThoughts;
    }

    public void setBookThoughts(List<BookThought> bookThoughts) {
        this.bookThoughts = bookThoughts;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", bookThoughts=" + bookThoughts + ", createdAt=" + createdAt + ", id=" + id
                + ", title=" + title + ", updatedAt=" + updatedAt + ", user=" + user + "]";
    }

    
}
