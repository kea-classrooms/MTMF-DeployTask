package com.example.superherov5.repositories;

import com.example.superherov5.dto.CityDTO;
import com.example.superherov5.dto.CountPowerDTO;
import com.example.superherov5.dto.SuperPowerDTO;
import com.example.superherov5.dto.SuperheroFormDTO;
import com.example.superherov5.model.Superhero;

import java.util.List;

public interface IRepository {
    List<Superhero> getSuperheroes();
    Superhero getSuperhero(String superheroName);
    List<CountPowerDTO> getSuperpowerCount();
    SuperPowerDTO getSuperPower(String SuperheroName);
    List<CityDTO> getCity();
    CityDTO getCitySuperheroName(String superheroName);
    List<String> getCities();
    List<String> getPowers();
    void addSuperHero(SuperheroFormDTO superheroFormDTO);

}
