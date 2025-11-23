package org.example.newbot.model;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "producttlar")
public class Product {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameUz() {
        return nameUz;
    }

    public void setNameUz(String nameUz) {
        this.nameUz = nameUz;
    }

    public String getDescriptionUz() {
        return descriptionUz;
    }

    public void setDescriptionUz(String descriptionUz) {
        this.descriptionUz = descriptionUz;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Product() {
    }

    public Product(Long id, String nameUz, String descriptionUz, String nameRu, String descriptionRu, String status, Boolean active, Long categoryId) {
        this.id = id;
        this.nameUz = nameUz;
        this.descriptionUz = descriptionUz;
        this.nameRu = nameRu;
        this.descriptionRu = descriptionRu;
        this.status = status;
        this.active = active;
        this.categoryId = categoryId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameUz;
    @Column(columnDefinition = "TEXT")
    private String descriptionUz;
    private String nameRu;
    @Column(columnDefinition = "TEXT")
    private String descriptionRu;
    private String status;
    private Boolean active;
    private Long categoryId;
}
