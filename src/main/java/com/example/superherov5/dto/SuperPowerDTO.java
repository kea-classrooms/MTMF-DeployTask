package com.example.superherov5.dto;

import java.util.List;

public class SuperPowerDTO {
    private String superheroName;
    private List<String> powerList;


    public SuperPowerDTO() {

    }
    public SuperPowerDTO(String superheroName, List<String> powerList){
        this.superheroName = superheroName;
        this.powerList = powerList;
    }


    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public List<String> getPowerList() {
        return powerList;
    }

    public void add(String power){
        powerList.add(power);
    }



}
