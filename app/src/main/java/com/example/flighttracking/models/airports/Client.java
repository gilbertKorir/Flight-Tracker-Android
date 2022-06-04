
package com.example.flighttracking.models.airports;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Client {

    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("geo")
    @Expose
    private Geo geo;
    @SerializedName("connection")
    @Expose
    private Connection connection;
    @SerializedName("device")
    @Expose
    private Device device;
    @SerializedName("agent")
    @Expose
    private Agent agent;
    @SerializedName("karma")
    @Expose
    private Karma karma;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Client() {
    }

    /**
     * 
     * @param geo
     * @param karma
     * @param agent
     * @param ip
     * @param connection
     * @param device
     */
    public Client(String ip, Geo geo, Connection connection, Device device, Agent agent, Karma karma) {
        super();
        this.ip = ip;
        this.geo = geo;
        this.connection = connection;
        this.device = device;
        this.agent = agent;
        this.karma = karma;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Karma getKarma() {
        return karma;
    }

    public void setKarma(Karma karma) {
        this.karma = karma;
    }

}
