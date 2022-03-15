package com.codingdojo.book_club.mvc.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookThoughtId implements Serializable {
    
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "user_id")
    private Long userId;

    public BookThoughtId () {}

    public BookThoughtId(Long bookId, Long userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        
        if (o == null || getClass() != o.getClass()) {return false;}

        BookThoughtId that = (BookThoughtId) o;
        return Objects.equals(bookId, that.bookId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, userId);
    }

    
}
