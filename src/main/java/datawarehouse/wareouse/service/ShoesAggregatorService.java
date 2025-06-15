package datawarehouse.wareouse.service;

import datawarehouse.wareouse.entity.Shoes;
import datawarehouse.wareouse.repo.db1.ShoesRepo1;
import datawarehouse.wareouse.repo.db2.ShoesRepo2;
import datawarehouse.wareouse.repo.db3.ShoesRepo3;
import datawarehouse.wareouse.specification.ShoeSpecifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoesAggregatorService {

    private final ShoesRepo1 repo1;
    private final ShoesRepo2 repo2;
    private final ShoesRepo3 repo3;

    @Autowired
    public ShoesAggregatorService(ShoesRepo1 repo1, ShoesRepo2 repo2, ShoesRepo3 repo3) {
        this.repo1 = repo1;
        this.repo2 = repo2;
        this.repo3 = repo3;
    }

    public List<Shoes> getAllShoes() {
        List<Shoes> allShoes = new ArrayList<>();
        allShoes.addAll(repo1.findAll());
        allShoes.addAll(repo2.findAll());
        allShoes.addAll(repo3.findAll());
        return allShoes;
    }

    public List<Shoes> getAllDb1(String brand, String model, Double minPrice, Double maxPrice) {
        return repo1.findAll(ShoeSpecifications.withFilters(brand, model, minPrice, maxPrice));
    }

    public List<Shoes> getAllDb2(String brand, String model, Double minPrice, Double maxPrice) {
        return repo2.findAll(ShoeSpecifications.withFilters(brand, model, minPrice, maxPrice));
    }

    public List<Shoes> getAllDb3(String brand, String model, Double minPrice, Double maxPrice) {
        return repo3.findAll(ShoeSpecifications.withFilters(brand, model, minPrice, maxPrice));
    }
    
}