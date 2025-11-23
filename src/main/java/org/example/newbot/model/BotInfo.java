package org.example.newbot.model;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bot_info")

public class BotInfo {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBotUsername() {
        return botUsername;
    }

    public void setBotUsername(String botUsername) {
        this.botUsername = botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Long> getAdminChatIds() {
        return adminChatIds;
    }

    public void setAdminChatIds(List<Long> adminChatIds) {
        this.adminChatIds = adminChatIds;
    }

    public List<BotUser> getUsers() {
        return users;
    }

    public void setUsers(List<BotUser> users) {
        this.users = users;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean free) {
        isFree = free;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String botUsername;
    @Column(unique = true)
    private String botToken;
    @Column(name = "type1e")
    private String type;
    private boolean active;
    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "bot_user_mapping", joinColumns = @JoinColumn(name = "bot_id"))
    private List<Long> adminChatIds = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "bot_user",
            joinColumns = @JoinColumn(name = "bot_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<BotUser> users;
    private Boolean isFree;
    private Date createdAt ;
    private Date updatedAt ;
    public BotInfo() {

    }

    public BotInfo(Long id, String botUsername, String botToken, boolean active) {
        this.id = id;
        this.botUsername = botUsername;
        this.botToken = botToken;
        this.active = active;
    }
}