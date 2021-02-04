package com.example.demo.Storage;

import com.example.demo.Models.PlantCatalog;
import org.springframework.stereotype.Service;

@Service
public class CatalogStorage {

    private CatalogRepository catalogRepo;

    public CatalogStorage(CatalogRepository catalogRepo) {
        this.catalogRepo = catalogRepo;
    }



    public Iterable<PlantCatalog> retrieveAllCatalogs() {
        return catalogRepo.findAll();
    }

    public PlantCatalog retrieveCatalogById(long id) {
        return catalogRepo.findById(id).get();
    }
}
