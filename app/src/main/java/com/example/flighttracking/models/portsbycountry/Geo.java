
package com.example.flighttracking.models.portsbycountry;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Geo {

    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("continent")
    @Expose
    private String continent;
    @SerializedName("lat")
    @Expose
    private Integer lat;
    @SerializedName("lng")
    @Expose
    private Integer lng;
    @SerializedName("timezone")
    @Expose
    private String timezone;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Geo() {
    }

    /**
     * 
     * @param continent
     * @param country
     * @param lng
     * @param countryCode
     * @param timezone
     * @param lat
     */
    public Geo(String countryCode, String country, String continent, Integer lat, Integer lng, String timezone) {
        super();
        this.countryCode = countryCode;
        this.country = country;
        this.continent = continent;
        this.lat = lat;
        this.lng = lng;
        this.timezone = timezone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLng() {
        return lng;
    }

    public void setLng(Integer lng) {
        this.lng = lng;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

}
