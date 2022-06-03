
package com.example.flighttracking.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CountrySearchResponse {

    @SerializedName("request")
    @Expose
    private Request request;
    @SerializedName("response")
    @Expose
    private List<Response> response = null;
    @SerializedName("terms")
    @Expose
    private String terms;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CountrySearchResponse() {
    }

    /**
     * 
     * @param request
     * @param terms
     * @param response
     */
    public CountrySearchResponse(Request request, List<Response> response, String terms) {
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

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

}
