package com.example.superherov5.dto;



public class CountPowerDTO {
    private String superheroName;
    private int power;


    public CountPowerDTO() {

    }
    public CountPowerDTO(String superheroName, int power){
        this.superheroName = superheroName;
        this.power = power;
    }


    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
