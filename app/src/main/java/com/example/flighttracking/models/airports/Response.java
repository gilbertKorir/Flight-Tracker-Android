
package com.example.flighttracking.models.airports;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("icao_code")
    @Expose
    private String icaoCode;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("iata_code")
    @Expose
    private String iataCode;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lat")
    @Expose
    private Double lat;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Response() {
    }

    /**
     * 
     * @param icaoCode
     * @param iataCode
     * @param lng
     * @param countryCode
     * @param name
     * @param lat
     */
    public Response(String icaoCode, String countryCode, String iataCode, Double lng, String name, Double lat) {
        super();
        this.icaoCode = icaoCode;
        this.countryCode = countryCode;
        this.iataCode = iataCode;
        this.lng = lng;
        this.name = name;
        this.lat = lat;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
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

}
