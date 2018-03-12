package com.example.edargham.restoview;

/**
 * Created by eliasdargham on 3/12/18.
 */

public class Location {

    private String address;
    private String locality;
    private String city;

    public Location (String addr, String local, String district) {
        address = addr;
        locality =local;
        city = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
