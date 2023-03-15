package com.example.superherov5.repositories;

import com.example.superherov5.dto.CityDTO;
import com.example.superherov5.dto.CountPowerDTO;
import com.example.superherov5.dto.SuperPowerDTO;
import com.example.superherov5.model.Superhero;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("dbRepository")
public class DBRepository implements IRepository {

    //Print all superheroes in superhero database
    @Override
    public List<Superhero> getSuperheroes() {
        List<Superhero> superheroes = new ArrayList<Superhero>();

        try (Connection con = DBManager.getConnection()) {
            String SQL = "SELECT superhero_id, superhero_name, reel_name, creation_year FROM superhero;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                int ID = rs.getInt("superhero_id");
                String superheroName = rs.getString("superhero_name");
                String reelName = rs.getString("reel_name");
                int creationYear = rs.getInt("creation_year");
                superheroes.add(new Superhero(ID, superheroName, reelName, creationYear));
            }
            return superheroes;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    @Override
    public Superhero getSuperhero(String superhero) {
        Superhero superhero1 = null;

        try (Connection con = DBManager.getConnection()) {
            String SQL = "SELECT superhero_id, superhero_name, reel_name, creation_year FROM superhero " +
                    "WHERE superhero_name = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, superhero);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("superhero_id");
                String superheroName = rs.getString("superhero_name");
                String reelName = rs.getString("reel_name");
                int creationYear = rs.getInt("creation_year");
                superhero1 = (new Superhero(ID, superheroName, reelName, creationYear));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return superhero1;

    }
    @Override
    public List<CountPowerDTO> getSuperpowerCount() {
        List<CountPowerDTO> superpowerCount = new ArrayList<CountPowerDTO>();
        try (Connection con = DBManager.getConnection()) {
            String SQL = "SELECT superhero.superhero_name, COUNT(superheropower.superhero_id) AS superpowerCount " +
                    "FROM superhero JOIN superheropower ON superhero.superhero_id = superheropower.superhero_id " +
                    "GROUP BY superhero.superhero_name;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String superheroName = rs.getString("superhero_name");
                int power = rs.getInt("superpowerCount");
                CountPowerDTO countPowerDTO = new CountPowerDTO(superheroName, power);
                superpowerCount.add(countPowerDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return superpowerCount;
    }



    @Override
    public SuperPowerDTO getSuperPower(String superhero) {
        SuperPowerDTO superhero1 = null;
        try (Connection con = DBManager.getConnection()) {
            String SQL = "SELECT superhero.SUPERHERO_NAME, Superpower.SUPERPOWER_NAME\n" +
                    "FROM superhero\n" +
                    "JOIN superheroPower ON superhero.SUPERHERO_ID = superheroPower.SUPERHERO_ID\n" +
                    "JOIN superpower ON superheroPower.SUPERPOWER_ID = superpower.SUPERPOWER_ID\n" +
                    "WHERE superhero.SUPERHERO_NAME = ?\n" + // Add WHERE clause to filter by superhero name
                    "ORDER BY superhero.SUPERHERO_NAME;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, superhero);
            ResultSet rs = pstmt.executeQuery();

            List<String> powers = new ArrayList<>();
            while (rs.next()) {
                String power = rs.getString("SUPERPOWER_NAME");
                powers.add(power);
            }
            superhero1 = new SuperPowerDTO(superhero, powers);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return superhero1;
    }
    @Override
    public List<CityDTO> getCity() {
        List<CityDTO> city = new ArrayList<CityDTO>();
        try (Connection con = DBManager.getConnection()) {
            String SQL = "SELECT city_name FROM city;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String cityName = rs.getString("city_name");
                city.add(new CityDTO(cityName));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }
    @Override
    public CityDTO getCitySuperheroName(String superhero) {
        CityDTO superhero1 = null;
        try (Connection con = DBManager.getConnection()) {
            String SQL = "SELECT superhero.superhero_name, city.city_name " +
                    "FROM superhero JOIN city ON superhero.superhero_id = city.city_id " +
                    "WHERE superhero.superhero_name = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, superhero);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String superheroName = rs.getString("superhero_name");
                String city_name = rs.getString("city_name");
                superhero1 = new CityDTO(superheroName, city_name);
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return superhero1;
    }

}









