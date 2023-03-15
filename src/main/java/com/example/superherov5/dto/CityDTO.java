package com.example.superherov5.dto;

public class CityDTO {
    private String superheroName;
    private String city;

    public CityDTO(String superheroName, String city) {
        this.superheroName = superheroName;
        this.city = city;
    }
    public CityDTO(String city) {
        this.city = city;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
