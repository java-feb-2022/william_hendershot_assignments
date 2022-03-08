package com.codingdojo.languages.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "languages")
public class Language {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updated_at;

    @NotNull
    @NotBlank
    @Size(min=2, max=20)
    private String name;

    @NotNull
    @NotBlank
    @Size(min=2, max=20)
    private String creator;

    @NotNull
    @NotBlank
    private String version;

    public Language () {}

    public Language(@NotNull @NotBlank @Size(min = 2, max = 20) String name,
            @NotNull @NotBlank @Size(min = 2, max = 20) String creator, @NotNull @NotBlank String version) {
        this.name = name;
        this.creator = creator;
        this.version = version;
    }

    @PrePersist
    protected void onCreate() {
        this.created_at = new Date();
        this.updated_at = this.created_at;
    }
    
    @PreUpdate()
    protected void onUpdate() {
        this.updated_at = new Date();
    }

    @Override
    public String toString() {
        return "Language [created_at=" + created_at + ", creator=" + creator + ", id=" + id + ", name=" + name
                + ", updated_at=" + updated_at + ", version=" + version + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    
}
