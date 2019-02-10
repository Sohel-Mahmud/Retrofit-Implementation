package com.example.sohel.retrofitipinfo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ServerResponse implements Serializable {
    @SerializedName("ip")

    private String ip;
    @SerializedName("ip_decimal")

    private Integer ipDecimal;
    @SerializedName("country")

    private String country;
    @SerializedName("country_eu")

    private Boolean countryEu;
    @SerializedName("country_iso")

    private String countryIso;
    @SerializedName("city")

    private String city;
    @SerializedName("latitude")

    private Double latitude;
    @SerializedName("longitude")

    private Double longitude;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getIpDecimal() {
        return ipDecimal;
    }

    public void setIpDecimal(Integer ipDecimal) {
        this.ipDecimal = ipDecimal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getCountryEu() {
        return countryEu;
    }

    public void setCountryEu(Boolean countryEu) {
        this.countryEu = countryEu;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
