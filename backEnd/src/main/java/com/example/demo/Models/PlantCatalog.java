package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class PlantCatalog {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    private List<Plant> plants;


    public PlantCatalog(String name, Plant... plants) {
        this.name = name;
        this.plants = List.of(plants);
    }

    protected PlantCatalog() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Plant> getPlants() {
        return plants;
    }




}
