
package com.example.flighttracking.models.portsbycountry;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Country {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("code3")
    @Expose
    private String code3;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Country() {
    }

    /**
     * 
     * @param code3
     * @param code
     * @param name
     */
    public Country(String name, String code, String code3) {
        super();
        this.name = name;
        this.code = code;
        this.code3 = code3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

}
