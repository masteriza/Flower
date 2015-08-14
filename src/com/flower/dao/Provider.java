package com.flower.dao;

/**
 * Created by user on 14.08.2015.
 */
public class Provider {
    int id;
    String provider;
    Double longitude;
    Double latitude;

    public Provider() {

    }

    public Provider(int id, String provider, Double longitude, Double latitude) {
        this.id = id;
        this.provider = provider;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /*public String getProvider() {
        return provider;
    }

    public void setProvider(int empno) {
        this.provider = provider;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }*/
}
