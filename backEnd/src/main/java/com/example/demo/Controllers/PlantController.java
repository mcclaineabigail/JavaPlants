package com.example.demo.Controllers;

import com.example.demo.Models.Plant;
import com.example.demo.Models.PlantCatalog;
import com.example.demo.Storage.CatalogRepository;
import com.example.demo.Storage.CatalogStorage;
import com.example.demo.Storage.PlantRepository;
import com.example.demo.Storage.PlantStorage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantController {

    private PlantRepository plantRepo;
    private PlantStorage plantStorage;
    private CatalogRepository catalogRepo;
    private CatalogStorage catalogStorage;

    public PlantController(PlantRepository plantRepo, PlantStorage plantStorage, CatalogRepository catalogRepo, CatalogStorage catalogStorage) {
        this.plantRepo = plantRepo;
        this.plantStorage = plantStorage;
        this.catalogRepo = catalogRepo;
        this.catalogStorage = catalogStorage;
    }

    @GetMapping("/api/plants")
    public Iterable<Plant> retrieveAllPlants(){
        return plantStorage.retrieveAllPlants();
    }

    @GetMapping("api/plant/{id}")
    public Plant retrievePlantById(@PathVariable Long id){
        return plantStorage.retrievePlantById(id);
    }

    @GetMapping("api/catalogs") //not working
    public Iterable<PlantCatalog> retrieveAllPlantCatalogs(){
        return catalogStorage.retrieveAllCatalogs();
    }

    @GetMapping("api/catalog/{id}")
    public PlantCatalog retrieveCatalogById(@PathVariable Long id){
        return catalogStorage.retrieveCatalogById(id);
    }

}
