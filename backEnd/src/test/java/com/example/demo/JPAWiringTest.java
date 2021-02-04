package com.example.demo;

import com.example.demo.Models.Plant;
import com.example.demo.Models.PlantCatalog;
import com.example.demo.Storage.CatalogRepository;
import com.example.demo.Storage.PlantRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class JPAWiringTest {


    @Autowired
    private PlantRepository plantRepo;
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private CatalogRepository catalogRepo;





    private void flushAndClear() {
        testEntityManager.flush();
        testEntityManager.clear();
    }

    @Test
    void ableToSavePlantAndRetrievePlant() {
        Plant testPlant = new Plant("plant", "2", "3", "4", "5");
        plantRepo.save(testPlant);
        PlantCatalog catalog = new PlantCatalog("Rebecca", testPlant);
        catalogRepo.save(catalog);
        flushAndClear();
        Plant retrievedPlant = plantRepo.findById(testPlant.getId()).get();
        Assertions.assertThat(retrievedPlant.equals(testPlant));
    }

    @Test
    void ableToCreateListOfPlants(){
        Plant testPlant = new Plant("plant", "2", "3", "4", "5");
        Plant testPlant2 = new Plant("plant2", "", "", "", "");
        PlantCatalog catalog = new PlantCatalog("Rebecca", testPlant, testPlant2);
        plantRepo.save(testPlant);
        plantRepo.save(testPlant2);
        catalogRepo.save(catalog);
        flushAndClear();
        PlantCatalog retrievedCatalog = catalogRepo.findById(catalog.getId()).get();
        Assertions.assertThat(retrievedCatalog.getPlants().contains(testPlant));
    }

}
