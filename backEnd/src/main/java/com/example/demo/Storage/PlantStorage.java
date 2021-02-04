package com.example.demo.Storage;

import com.example.demo.Models.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantStorage {

    private PlantRepository plantRepo;

    public PlantStorage(PlantRepository plantRepo) {
        this.plantRepo = plantRepo;
    }



    public Iterable<Plant> retrieveAllPlants() {
        return plantRepo.findAll();
    }

    public Plant retrievePlantById(long id) {
        return plantRepo.findById(id).get();

    }
}
