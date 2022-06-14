
package com.example.flighttracking.models.flights;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Response {

    @SerializedName("aircraft_icao")
    @Expose
    private String aircraftIcao;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("hex")
    @Expose
    private String hex;
    @SerializedName("reg_number")
    @Expose
    private String regNumber;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("alt")
    @Expose
    private Integer alt;
    @SerializedName("dir")
    @Expose
    private Integer dir;
    @SerializedName("speed")
    @Expose
    private Integer speed;
    @SerializedName("v_speed")
    @Expose
    private Integer vSpeed;
    @SerializedName("flight_number")
    @Expose
    private String flightNumber;
    @SerializedName("flight_icao")
    @Expose
    private String flightIcao;
    @SerializedName("flight_iata")
    @Expose
    private String flightIata;
    @SerializedName("dep_icao")
    @Expose
    private String depIcao;
    @SerializedName("dep_iata")
    @Expose
    private String depIata;
    @SerializedName("arr_icao")
    @Expose
    private String arrIcao;
    @SerializedName("arr_iata")
    @Expose
    private String arrIata;
    @SerializedName("airline_icao")
    @Expose
    private String airlineIcao;
    @SerializedName("airline_iata")
    @Expose
    private String airlineIata;
    @SerializedName("updated")
    @Expose
    private Integer updated;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("dep_terminal")
    @Expose
    private Object depTerminal;
    @SerializedName("dep_gate")
    @Expose
    private Object depGate;
    @SerializedName("dep_time")
    @Expose
    private String depTime;
    @SerializedName("dep_time_utc")
    @Expose
    private String depTimeUtc;
    @SerializedName("arr_terminal")
    @Expose
    private String arrTerminal;
    @SerializedName("arr_gate")
    @Expose
    private String arrGate;
    @SerializedName("arr_baggage")
    @Expose
    private String arrBaggage;
    @SerializedName("arr_time")
    @Expose
    private String arrTime;
    @SerializedName("arr_time_utc")
    @Expose
    private String arrTimeUtc;
    @SerializedName("cs_airline_iata")
    @Expose
    private Object csAirlineIata;
    @SerializedName("cs_flight_number")
    @Expose
    private Object csFlightNumber;
    @SerializedName("cs_flight_iata")
    @Expose
    private Object csFlightIata;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("delayed")
    @Expose
    private Object delayed;
    @SerializedName("arr_time_ts")
    @Expose
    private Integer arrTimeTs;
    @SerializedName("dep_time_ts")
    @Expose
    private Integer depTimeTs;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Response() {
    }

    /**
     * 
     * @param flag
     * @param flightIcao
     * @param depTimeTs
     * @param flightIata
     * @param delayed
     * @param csFlightNumber
     * @param dir
     * @param arrTimeUtc
     * @param speed
     * @param manufacturer
     * @param arrBaggage
     * @param vSpeed
     * @param duration
     * @param regNumber
     * @param depTimeUtc
     * @param hex
     * @param depTerminal
     * @param lat
     * @param aircraftIcao
     * @param depIata
     * @param arrGate
     * @param arrTimeTs
     * @param depIcao
     * @param lng
     * @param csAirlineIata
     * @param depTime
     * @param arrIcao
     * @param alt
     * @param arrIata
     * @param depGate
     * @param flightNumber
     * @param airlineIcao
     * @param airlineIata
     * @param csFlightIata
     * @param arrTerminal
     * @param updated
     * @param arrTime
     * @param status
     */
    public Response(String aircraftIcao, String manufacturer, String hex, String regNumber, String flag, Double lat, Double lng, Integer alt, Integer dir, Integer speed, Integer vSpeed, String flightNumber, String flightIcao, String flightIata, String depIcao, String depIata, String arrIcao, String arrIata, String airlineIcao, String airlineIata, Integer updated, String status, Object depTerminal, Object depGate, String depTime, String depTimeUtc, String arrTerminal, String arrGate, String arrBaggage, String arrTime, String arrTimeUtc, Object csAirlineIata, Object csFlightNumber, Object csFlightIata, Integer duration, Object delayed, Integer arrTimeTs, Integer depTimeTs) {
        super();
        this.aircraftIcao = aircraftIcao;
        this.manufacturer = manufacturer;
        this.hex = hex;
        this.regNumber = regNumber;
        this.flag = flag;
        this.lat = lat;
        this.lng = lng;
        this.alt = alt;
        this.dir = dir;
        this.speed = speed;
        this.vSpeed = vSpeed;
        this.flightNumber = flightNumber;
        this.flightIcao = flightIcao;
        this.flightIata = flightIata;
        this.depIcao = depIcao;
        this.depIata = depIata;
        this.arrIcao = arrIcao;
        this.arrIata = arrIata;
        this.airlineIcao = airlineIcao;
        this.airlineIata = airlineIata;
        this.updated = updated;
        this.status = status;
        this.depTerminal = depTerminal;
        this.depGate = depGate;
        this.depTime = depTime;
        this.depTimeUtc = depTimeUtc;
        this.arrTerminal = arrTerminal;
        this.arrGate = arrGate;
        this.arrBaggage = arrBaggage;
        this.arrTime = arrTime;
        this.arrTimeUtc = arrTimeUtc;
        this.csAirlineIata = csAirlineIata;
        this.csFlightNumber = csFlightNumber;
        this.csFlightIata = csFlightIata;
        this.duration = duration;
        this.delayed = delayed;
        this.arrTimeTs = arrTimeTs;
        this.depTimeTs = depTimeTs;
    }

    public String getAircraftIcao() {
        return aircraftIcao;
    }

    public void setAircraftIcao(String aircraftIcao) {
        this.aircraftIcao = aircraftIcao;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public Integer getAlt() {
        return alt;
    }

    public void setAlt(Integer alt) {
        this.alt = alt;
    }

    public Integer getDir() {
        return dir;
    }

    public void setDir(Integer dir) {
        this.dir = dir;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getvSpeed() {
        return vSpeed;
    }

    public void setvSpeed(Integer vSpeed) {
        this.vSpeed = vSpeed;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightIcao() {
        return flightIcao;
    }

    public void setFlightIcao(String flightIcao) {
        this.flightIcao = flightIcao;
    }

    public String getFlightIata() {
        return flightIata;
    }

    public void setFlightIata(String flightIata) {
        this.flightIata = flightIata;
    }

    public String getDepIcao() {
        return depIcao;
    }

    public void setDepIcao(String depIcao) {
        this.depIcao = depIcao;
    }

    public String getDepIata() {
        return depIata;
    }

    public void setDepIata(String depIata) {
        this.depIata = depIata;
    }

    public String getArrIcao() {
        return arrIcao;
    }

    public void setArrIcao(String arrIcao) {
        this.arrIcao = arrIcao;
    }

    public String getArrIata() {
        return arrIata;
    }

    public void setArrIata(String arrIata) {
        this.arrIata = arrIata;
    }

    public String getAirlineIcao() {
        return airlineIcao;
    }

    public void setAirlineIcao(String airlineIcao) {
        this.airlineIcao = airlineIcao;
    }

    public String getAirlineIata() {
        return airlineIata;
    }

    public void setAirlineIata(String airlineIata) {
        this.airlineIata = airlineIata;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getDepTerminal() {
        return depTerminal;
    }

    public void setDepTerminal(Object depTerminal) {
        this.depTerminal = depTerminal;
    }

    public Object getDepGate() {
        return depGate;
    }

    public void setDepGate(Object depGate) {
        this.depGate = depGate;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getDepTimeUtc() {
        return depTimeUtc;
    }

    public void setDepTimeUtc(String depTimeUtc) {
        this.depTimeUtc = depTimeUtc;
    }

    public String getArrTerminal() {
        return arrTerminal;
    }

    public void setArrTerminal(String arrTerminal) {
        this.arrTerminal = arrTerminal;
    }

    public String getArrGate() {
        return arrGate;
    }

    public void setArrGate(String arrGate) {
        this.arrGate = arrGate;
    }

    public String getArrBaggage() {
        return arrBaggage;
    }

    public void setArrBaggage(String arrBaggage) {
        this.arrBaggage = arrBaggage;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getArrTimeUtc() {
        return arrTimeUtc;
    }

    public void setArrTimeUtc(String arrTimeUtc) {
        this.arrTimeUtc = arrTimeUtc;
    }

    public Object getCsAirlineIata() {
        return csAirlineIata;
    }

    public void setCsAirlineIata(Object csAirlineIata) {
        this.csAirlineIata = csAirlineIata;
    }

    public Object getCsFlightNumber() {
        return csFlightNumber;
    }

    public void setCsFlightNumber(Object csFlightNumber) {
        this.csFlightNumber = csFlightNumber;
    }

    public Object getCsFlightIata() {
        return csFlightIata;
    }

    public void setCsFlightIata(Object csFlightIata) {
        this.csFlightIata = csFlightIata;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Object getDelayed() {
        return delayed;
    }

    public void setDelayed(Object delayed) {
        this.delayed = delayed;
    }

    public Integer getArrTimeTs() {
        return arrTimeTs;
    }

    public void setArrTimeTs(Integer arrTimeTs) {
        this.arrTimeTs = arrTimeTs;
    }

    public Integer getDepTimeTs() {
        return depTimeTs;
    }

    public void setDepTimeTs(Integer depTimeTs) {
        this.depTimeTs = depTimeTs;
    }

}
