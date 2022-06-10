
package com.example.flighttracking.models.portsbycountry;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Response {

    @SerializedName("countries")
    @Expose
    private List<Country> countries = null;
//    @SerializedName("cities")
//    @Expose
//    private List<Object> cities = null;
    @SerializedName("airports")
    @Expose
    private List<Airport> airports = null;
    @SerializedName("cities_by_airports")
    @Expose
    private List<CitiesByAirport> citiesByAirports = null;
    @SerializedName("cities_by_countries")
    @Expose
    private List<CitiesByCountry> citiesByCountries = null;
//    @SerializedName("airports_by_cities")
//    @Expose
//    private List<Object> airportsByCities = null;
    @SerializedName("airports_by_countries")
    @Expose
    private List<AirportsByCountry> airportsByCountries = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Response() {
    }

    /**
     * 
     * @param citiesByCountries
     * @param cities
     * @param airportsByCities
     * @param citiesByAirports
     * @param airportsByCountries
     * @param countries
     * @param airports
     */
    public Response(List<Country> countries, List<Object> cities, List<Airport> airports, List<CitiesByAirport> citiesByAirports, List<CitiesByCountry> citiesByCountries, List<Object> airportsByCities, List<AirportsByCountry> airportsByCountries) {
        super();
        this.countries = countries;
//        this.cities = cities;
        this.airports = airports;
        this.citiesByAirports = citiesByAirports;
        this.citiesByCountries = citiesByCountries;
//        this.airportsByCities = airportsByCities;
        this.airportsByCountries = airportsByCountries;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

//    public List<Object> getCities() {
//        return cities;
//    }

//    public void setCities(List<Object> cities) {
//        this.cities = cities;
//    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public List<CitiesByAirport> getCitiesByAirports() {
        return citiesByAirports;
    }

    public void setCitiesByAirports(List<CitiesByAirport> citiesByAirports) {
        this.citiesByAirports = citiesByAirports;
    }

    public List<CitiesByCountry> getCitiesByCountries() {
        return citiesByCountries;
    }

    public void setCitiesByCountries(List<CitiesByCountry> citiesByCountries) {
        this.citiesByCountries = citiesByCountries;
    }

//    public List<Object> getAirportsByCities() {
//        return airportsByCities;
//    }

//    public void setAirportsByCities(List<Object> airportsByCities) {
//        this.airportsByCities = airportsByCities;
//    }

    public List<AirportsByCountry> getAirportsByCountries() {
        return airportsByCountries;
    }

    public void setAirportsByCountries(List<AirportsByCountry> airportsByCountries) {
        this.airportsByCountries = airportsByCountries;
    }

}
