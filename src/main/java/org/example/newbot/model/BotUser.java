package org.example.newbot.model;

import jakarta.persistence.*;

import java.util.List;

@Entity

@Table(name = "bot_users")
public class BotUser {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Long getChatIdHelp() {
        return chatIdHelp;
    }

    public void setChatIdHelp(Long chatIdHelp) {
        this.chatIdHelp = chatIdHelp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHelperPhone() {
        return helperPhone;
    }

    public void setHelperPhone(String helperPhone) {
        this.helperPhone = helperPhone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getHelperValue() {
        return helperValue;
    }

    public void setHelperValue(String helperValue) {
        this.helperValue = helperValue;
    }

    public List<BotInfo> getBots() {
        return bots;
    }

    public void setBots(List<BotInfo> bots) {
        this.bots = bots;
    }

    public Long getBotUserId() {
        return botUserId;
    }

    public void setBotUserId(Long botUserId) {
        this.botUserId = botUserId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductVariantId() {
        return productVariantId;
    }

    public void setProductVariantId(Long productVariantId) {
        this.productVariantId = productVariantId;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String nickname;
    private String username;
    @Column(name = "chatid1")
    private Long chatId;
    private String lang;
    private Long chatIdHelp;
    private String phone;
    private String helperPhone;
    private String role;
    private Integer page=0;
    private String eventCode;
    private String helperValue;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private List<BotInfo> bots;
    private Long botUserId;
    private Long categoryId;
    private Long productId;
    private Long productVariantId;

    private String deliveryType;

    private Double latitude;
    private Double longitude;
    private String address;
    private Integer branchId;
}
