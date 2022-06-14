
package com.example.flighttracking.models.flights;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Request {

    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("host")
    @Expose
    private String host;
    @SerializedName("pid")
    @Expose
    private Integer pid;
    @SerializedName("key")
    @Expose
    private Key key;
    @SerializedName("params")
    @Expose
    private Params params;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("client")
    @Expose
    private Client client;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Request() {
    }

    /**
     * 
     * @param server
     * @param method
     * @param host
     * @param client
     * @param currency
     * @param pid
     * @param time
     * @param id
     * @param lang
     * @param params
     * @param version
     * @param key
     */
    public Request(String lang, String currency, Integer time, String id, String server, String host, Integer pid, Key key, Params params, Integer version, String method, Client client) {
        super();
        this.lang = lang;
        this.currency = currency;
        this.time = time;
        this.id = id;
        this.server = server;
        this.host = host;
        this.pid = pid;
        this.key = key;
        this.params = params;
        this.version = version;
        this.method = method;
        this.client = client;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
