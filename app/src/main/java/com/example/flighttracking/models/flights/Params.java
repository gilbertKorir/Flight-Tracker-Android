
package com.example.flighttracking.models.flights;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Params {

    @SerializedName("flight_iata")
    @Expose
    private String flightIata;
    @SerializedName("lang")
    @Expose
    private String lang;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Params() {
    }

    /**
     * 
     * @param flightIata
     * @param lang
     */
    public Params(String flightIata, String lang) {
        super();
        this.flightIata = flightIata;
        this.lang = lang;
    }

    public String getFlightIata() {
        return flightIata;
    }

    public void setFlightIata(String flightIata) {
        this.flightIata = flightIata;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

}
