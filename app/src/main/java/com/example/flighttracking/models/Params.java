
package com.example.flighttracking.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Params {

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
     * @param lang
     */
    public Params(String lang) {
        super();
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

}
