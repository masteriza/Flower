package com.flower.dao;

/**
 * Created by user on 14.08.2015.
 */
public class Service {
    int id;
    String provider;
    String service;
    Double price;
    Double longitude;
    Double latitude;

    public Service() {

    }

    public Service(int id, String provider, String service, Double price, Double longitude, Double latitude) {
        this.id = id;
        this.provider = provider;
        this.service = service;
        this.price = price;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getlongitude() {
        return longitude;
    }

    public void setlongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getlatitude() {
        return longitude;
    }

    public void setlatitude(Double latitude) {
        this.latitude = latitude;
    }
}
