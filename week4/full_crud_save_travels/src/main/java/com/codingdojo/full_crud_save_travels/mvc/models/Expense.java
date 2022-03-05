package com.codingdojo.full_crud_save_travels.mvc.models;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "expenses")
public class Expense {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created_at;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updated_at;

    @NotNull
    @NotBlank
    @Size(min=3, max = 255)
    private String name;

    @NotNull
    @NotBlank
    @Size(min=3, max = 255)
    private String vendor;

    @NotNull
    @NotBlank
    @Size(min=3, max = 255)
    private String description;

    @NotNull
    @Positive
    @Min(value=0)
    private double amount;

    public Expense() {}

    public Expense(@NotNull String name, @NotNull String vendor, @NotNull String description, @NotNull double amount) {
        this.name = name;
        this.vendor = vendor;
        this.description = description;
        this.amount = amount;
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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        String result = "";
        result  += String.format("Id: %s%n", id);
        result  += String.format("Name: %s%n", name);
        result  += String.format("Vendor: %s%n", vendor);
        result  += String.format("Amount: %f%n", amount);
        result  += String.format("Description: %s%n", description);
        return result;
    }
}
