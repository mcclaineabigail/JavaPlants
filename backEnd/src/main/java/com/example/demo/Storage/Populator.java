package com.example.demo.Storage;

import com.example.demo.Models.Plant;
import com.example.demo.Models.PlantCatalog;
import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    private CatalogRepository catalogRepo;
    private PlantRepository plantRepo;

    public Populator(CatalogRepository catalogRepo, PlantRepository plantRepo) {
        this.catalogRepo = catalogRepo;
        this.plantRepo = plantRepo;
    }


    @Override
    public void run(String... args) throws Exception {

        Plant peperomia = new Plant("Peperomia", "/light/low-med.png", "/plant-images/peperomia.PNG", "Allow to Dry", "Poisonous");
        Plant chineseEvergreen = new Plant("Chinese Evergreen", "/light/low-med.png", "/plant-images/chinese-evergreen.PNG", "Keep Evenly Moist", "Poisonous");
        Plant grapeIvy = new Plant("Grape Ivy", "/light/med.png", "/plant-images/grape-ivy.PNG", "Keep Evenly Moist", "Trailing");
        Plant norfolkPine = new Plant("Norfolk Island Pine", "/light/bright.png", "/plant-images/norfolk-island-pine.PNG", "Allow to Dry", "Festive");

        plantRepo.save(peperomia);
        plantRepo.save(chineseEvergreen);
        plantRepo.save(grapeIvy);
        plantRepo.save(norfolkPine);

        PlantCatalog catalog1 = new PlantCatalog("Abigail", peperomia, chineseEvergreen, grapeIvy, norfolkPine);
        catalogRepo.save(catalog1);


    }


}
