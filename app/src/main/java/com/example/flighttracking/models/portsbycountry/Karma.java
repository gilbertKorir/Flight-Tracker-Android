
package com.example.flighttracking.models.portsbycountry;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Karma {

    @SerializedName("is_blocked")
    @Expose
    private Boolean isBlocked;
    @SerializedName("is_crawler")
    @Expose
    private Boolean isCrawler;
    @SerializedName("is_bot")
    @Expose
    private Boolean isBot;
    @SerializedName("is_friend")
    @Expose
    private Boolean isFriend;
    @SerializedName("is_regular")
    @Expose
    private Boolean isRegular;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Karma() {
    }

    /**
     * 
     * @param isBot
     * @param isRegular
     * @param isBlocked
     * @param isFriend
     * @param isCrawler
     */
    public Karma(Boolean isBlocked, Boolean isCrawler, Boolean isBot, Boolean isFriend, Boolean isRegular) {
        super();
        this.isBlocked = isBlocked;
        this.isCrawler = isCrawler;
        this.isBot = isBot;
        this.isFriend = isFriend;
        this.isRegular = isRegular;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Boolean getIsCrawler() {
        return isCrawler;
    }

    public void setIsCrawler(Boolean isCrawler) {
        this.isCrawler = isCrawler;
    }

    public Boolean getIsBot() {
        return isBot;
    }

    public void setIsBot(Boolean isBot) {
        this.isBot = isBot;
    }

    public Boolean getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Boolean isFriend) {
        this.isFriend = isFriend;
    }

    public Boolean getIsRegular() {
        return isRegular;
    }

    public void setIsRegular(Boolean isRegular) {
        this.isRegular = isRegular;
    }

}
