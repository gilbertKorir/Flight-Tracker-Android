
package com.example.flighttracking.models.portsbycountry;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CitiesByAirport {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("popularity")
    @Expose
    private Integer popularity;
    @SerializedName("city_code")
    @Expose
    private String cityCode;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CitiesByAirport() {
    }

    /**
     * 
     * @param lng
     * @param countryCode
     * @param cityCode
     * @param popularity
     * @param name
     * @param lat
     * @param slug
     */
    public CitiesByAirport(String name, Double lat, Double lng, String slug, String countryCode, Integer popularity, String cityCode) {
        super();
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.slug = slug;
        this.countryCode = countryCode;
        this.popularity = popularity;
        this.cityCode = cityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

}
