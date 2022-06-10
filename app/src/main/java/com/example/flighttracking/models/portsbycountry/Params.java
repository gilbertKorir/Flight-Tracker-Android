
package com.example.flighttracking.models.portsbycountry;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Params {

    @SerializedName("q")
    @Expose
    private String q;
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
     * @param q
     * @param lang
     */
    public Params(String q, String lang) {
        super();
        this.q = q;
        this.lang = lang;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

}
