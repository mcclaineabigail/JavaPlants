package com.example.demo.Storage;

import com.example.demo.Models.PlantCatalog;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository <PlantCatalog, Long> {
}
