package com.example.superherov5.repositories;

import com.example.superherov5.dto.CityDTO;
import com.example.superherov5.dto.CountPowerDTO;
import com.example.superherov5.dto.SuperPowerDTO;
import com.example.superherov5.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("stubRepository")
public class StubRepository implements IRepository {

    //TEST DATA
    private Superhero superhero1 = new Superhero(1, "Superman", "Clark Kent",  1938);
    private Superhero superhero2 = new Superhero(2, "Batman",  "Bruce Wayne",  1939);
    private Superhero superhero3 = new Superhero(3, "The Flash", "Barry Allen", 1956);
    private Superhero superhero4 = new Superhero(4, "Green Arrow",  "Oliver Queen",  1941);
    private Superhero superhero5 = new Superhero(5, "Supergirl",  "Kara Danvers", 1959);

    private CityDTO city1 = new CityDTO("Superman", "Metropolis");
    private CityDTO city2 = new CityDTO("Batman", "Gotham City");
    private CityDTO city3 = new CityDTO("The Flash", "Central City");
    private CityDTO city4 = new CityDTO("Green Arrow", "Star City");
    private CityDTO city5 = new CityDTO("Supergirl", "National City");

    private CountPowerDTO sumPower1 = new CountPowerDTO("Superman", 1);
    private CountPowerDTO sumPower2 = new CountPowerDTO("Superman", 2);
    private CountPowerDTO sumPower3 = new CountPowerDTO("Batman", 3);
    private CountPowerDTO sumPower4 = new CountPowerDTO("Batman", 4);
    private CountPowerDTO sumPower5 = new CountPowerDTO("The Flash", 3);
    private CountPowerDTO sumPower6 = new CountPowerDTO("Green Arrow", 4);
    private CountPowerDTO sumPower7 = new CountPowerDTO("Supergirl", 1);
    private CountPowerDTO sumPower8 = new CountPowerDTO("Supergirl", 3);

    private List<Superhero> superheroes = new ArrayList<>(Arrays.asList(superhero1,superhero2,superhero3,superhero4,superhero5));
    private List<CityDTO> cities = new ArrayList<>(Arrays.asList(city1,city2,city3,city4,city5));

    private List<CountPowerDTO> sumPower = new ArrayList<>(Arrays.asList(sumPower1,sumPower2,sumPower3,sumPower4,sumPower5,sumPower6, sumPower7, sumPower8));


    // List with data so we can share the data throug other methods
    private List<CityDTO> cityAndSuperheroName = new ArrayList<>();


    @Override
    public List<Superhero> getSuperheroes(){
        List<Superhero> searchResults = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            searchResults.add(superhero);
        }
        return searchResults;
    }
    @Override
    public Superhero getSuperhero(String superheroName){
        Superhero superhero1 = null;
        for (Superhero superhero : superheroes) {
            String name = superhero.getSuperHeroName().toLowerCase();
            if (name.contains(superheroName.toLowerCase().trim())) {
                superhero1 = (new Superhero(superhero.getsuperheroId(),superhero.getSuperHeroName(), superhero.getReelName(), superhero.getCreationYear()));
            }
        }
        return superhero1;
    }
    @Override
    public List<CountPowerDTO> getSuperpowerCount() {
        Map<String, CountPowerDTO> superheroPowerMap = new HashMap<>();
        int startPower = 1;
        for (CountPowerDTO powerDTO : sumPower) {
            String superheroName = powerDTO.getSuperheroName();
            if (superheroPowerMap.containsKey(superheroName)) {
                superheroPowerMap.get(superheroName).setPower(superheroPowerMap.get(superheroName).getPower() + 1);
            } else {
                superheroPowerMap.put(superheroName, new CountPowerDTO(superheroName, startPower));
            }
        }
        return new ArrayList<>(superheroPowerMap.values());
    }
    @Override
    public SuperPowerDTO getSuperPower(String superheroName){
        return null;
    }
    @Override
    public List<CityDTO> getCity(){

        CityDTO city1 = null;
        for (CityDTO city : cities) {
            city1 = new CityDTO(city.getSuperheroName(), city.getCity());
            cityAndSuperheroName.add(city1);
        }
        return cityAndSuperheroName;
    }
    @Override
    public CityDTO getCitySuperheroName(String superheroName){
        CityDTO city1 = null;
        for (CityDTO city : cityAndSuperheroName){
            if(city.getSuperheroName().equals(superheroName)){
                city1 = city;
            }
        }
        return city1;
    }
}
