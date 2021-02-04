package com.example.demo.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Plant {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String sun;
    private String image;
    private String water;
    private String notes;
    @ManyToOne
    private PlantCatalog catalog;

    public Plant(String name, String sun, String image, String water, String notes) {
        this.name = name;
        this.sun = sun;
        this.image = image;
        this.water = water;
        this.notes = notes;
    }

    protected Plant() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSun() {
        return sun;
    }

    public String getImage() {
        return image;
    }

    public String getWater() {
        return water;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return id == plant.id && Objects.equals(name, plant.name) && Objects.equals(sun, plant.sun) && Objects.equals(image, plant.image) && Objects.equals(water, plant.water) && Objects.equals(notes, plant.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sun, image, water, notes);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sun='" + sun + '\'' +
                ", image='" + image + '\'' +
                ", water='" + water + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
