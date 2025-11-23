package org.example.newbot.model;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "categories121")
public class Category {
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

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
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

    public Long getBotId() {
        return botId;
    }

    public void setBotId(Long botId) {
        this.botId = botId;
    }

    public Category() {
    }

    public Category(Long id, String nameUz, String nameRu, String status, Boolean active, Long botId) {
        this.id = id;
        this.nameUz = nameUz;
        this.nameRu = nameRu;
        this.status = status;
        this.active = active;
        this.botId = botId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameUz;
    private String nameRu;
    private String status;
    private Boolean active;
    private Long botId;
}
