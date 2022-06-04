
package com.example.flighttracking.models.airports;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Connection {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("isp_code")
    @Expose
    private Integer ispCode;
    @SerializedName("isp_name")
    @Expose
    private String ispName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Connection() {
    }

    /**
     * 
     * @param ispCode
     * @param ispName
     * @param type
     */
    public Connection(String type, Integer ispCode, String ispName) {
        super();
        this.type = type;
        this.ispCode = ispCode;
        this.ispName = ispName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIspCode() {
        return ispCode;
    }

    public void setIspCode(Integer ispCode) {
        this.ispCode = ispCode;
    }

    public String getIspName() {
        return ispName;
    }

    public void setIspName(String ispName) {
        this.ispName = ispName;
    }

}
