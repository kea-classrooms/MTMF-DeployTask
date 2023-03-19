package com.example.superherov5.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class SuperheroFormDTO {
    private int heroId;
    private String heroName;
    private String realName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date creationDate;
    private String city;
    List<String> powerList;

    public SuperheroFormDTO(int heroId, String heroName, String realName, java.sql.Date creationDate, String city, List<String> powerList) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.realName = realName;
        this.creationDate = creationDate;
        this.city = city;
        this.powerList = powerList;

    }

    public SuperheroFormDTO() {
    }


    public void add(String power) {

        powerList.add(power);
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public java.sql.Date getCreationDate() {
        return (java.sql.Date) creationDate;
    }

    public void setCreationYear(java.sql.Date creationYear) {
        this.creationDate = creationYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<String> powerList) {
        this.powerList = powerList;
    }
}