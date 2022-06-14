
package com.example.flighttracking.models.portsbycountry;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class AirportsByCountry {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("iata_code")
    @Expose
    private String iataCode;
    @SerializedName("icao_code")
    @Expose
    private String icaoCode;
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
    private Double popularity;
    @SerializedName("city_code")
    @Expose
    private String cityCode;

    /**
     * No args constructor for use in serialization
     * 
     */
    private String pushId;
    public AirportsByCountry() {
    }

    /**
     * 
     * @param iataCode
     * @param icaoCode
     * @param lng
     * @param countryCode
     * @param cityCode
     * @param popularity
     * @param name
     * @param lat
     * @param slug
     */
    public AirportsByCountry(String name, String iataCode, String icaoCode, Double lat, Double lng, String slug, String countryCode, Double popularity, String cityCode) {
        super();
        this.name = name;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
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

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
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

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

}
