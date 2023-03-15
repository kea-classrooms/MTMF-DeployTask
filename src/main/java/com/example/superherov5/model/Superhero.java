package com.example.superherov5.model;

import java.util.List;

public class Superhero {
    private int superheroId;
    private String superHeroName;
    private String reelName;
    private int creationYear;



    //konstruktør
    public Superhero(int superheroId, String superHeroName, String reelName, int creationYear){
        this.superheroId = superheroId;
        this.superHeroName = superHeroName;
        this.reelName = reelName;
        this.creationYear = creationYear;
    }
    public Superhero(){}

    //Gettere
    public String getSuperHeroName() {
        return superHeroName;
    }
    public String getReelName() {
        return reelName;
    }


    public int getCreationYear() {
        return creationYear;
    }

    public int getsuperheroId(){
        return superheroId;
    }

    public void setSuperheroName(String newSuperheroName) {
        this.superHeroName = newSuperheroName;
    }
    public void setReelName(String newReelName) {
        this.reelName = newReelName;
    }
    public void setCreationYear(String newCreationYear) {
        this.creationYear = Integer.parseInt(newCreationYear);
    }


}

