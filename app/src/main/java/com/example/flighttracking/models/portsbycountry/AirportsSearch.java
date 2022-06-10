
package com.example.flighttracking.models.portsbycountry;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class AirportsSearch {

    @SerializedName("request")
    @Expose
    private Request request;
    @SerializedName("response")
    @Expose
    private Response response;
    @SerializedName("terms")
    @Expose
    private String terms;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AirportsSearch() {
    }

    /**
     * 
     * @param request
     * @param terms
     * @param response
     */
    public AirportsSearch(Request request, Response response, String terms) {
        super();
        this.request = request;
        this.response = response;
        this.terms = terms;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

}
