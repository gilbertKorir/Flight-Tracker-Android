
package com.example.flighttracking.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Key {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("api_key")
    @Expose
    private String apiKey;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("expired")
    @Expose
    private String expired;
    @SerializedName("registered")
    @Expose
    private String registered;
    @SerializedName("limits_by_hour")
    @Expose
    private Integer limitsByHour;
    @SerializedName("limits_by_minute")
    @Expose
    private Integer limitsByMinute;
    @SerializedName("limits_by_month")
    @Expose
    private Integer limitsByMonth;
    @SerializedName("limits_total")
    @Expose
    private Integer limitsTotal;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Key() {
    }

    /**
     * 
     * @param limitsTotal
     * @param limitsByMonth
     * @param expired
     * @param apiKey
     * @param limitsByHour
     * @param limitsByMinute
     * @param registered
     * @param id
     * @param type
     */
    public Key(Integer id, String apiKey, String type, String expired, String registered, Integer limitsByHour, Integer limitsByMinute, Integer limitsByMonth, Integer limitsTotal) {
        super();
        this.id = id;
        this.apiKey = apiKey;
        this.type = type;
        this.expired = expired;
        this.registered = registered;
        this.limitsByHour = limitsByHour;
        this.limitsByMinute = limitsByMinute;
        this.limitsByMonth = limitsByMonth;
        this.limitsTotal = limitsTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public Integer getLimitsByHour() {
        return limitsByHour;
    }

    public void setLimitsByHour(Integer limitsByHour) {
        this.limitsByHour = limitsByHour;
    }

    public Integer getLimitsByMinute() {
        return limitsByMinute;
    }

    public void setLimitsByMinute(Integer limitsByMinute) {
        this.limitsByMinute = limitsByMinute;
    }

    public Integer getLimitsByMonth() {
        return limitsByMonth;
    }

    public void setLimitsByMonth(Integer limitsByMonth) {
        this.limitsByMonth = limitsByMonth;
    }

    public Integer getLimitsTotal() {
        return limitsTotal;
    }

    public void setLimitsTotal(Integer limitsTotal) {
        this.limitsTotal = limitsTotal;
    }

}
