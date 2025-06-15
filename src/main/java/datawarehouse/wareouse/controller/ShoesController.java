package datawarehouse.wareouse.controller;

import datawarehouse.wareouse.entity.Shoes;
import datawarehouse.wareouse.service.ShoesAggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zapatos")
public class ShoesController {

    private final ShoesAggregatorService shoesAggregatorService;

    @Autowired
    public ShoesController(ShoesAggregatorService shoesAggregatorService) {
        this.shoesAggregatorService = shoesAggregatorService;
    }

    @GetMapping
    public List<Shoes> getAllShoes() {
        return shoesAggregatorService.getAllShoes();
    }

    @GetMapping("/zapateria1")
    public List<Shoes> getAllDb1(
        @RequestParam(required = false) String brand,
        @RequestParam(required = false) String model,
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice
    ) {
    return shoesAggregatorService.getAllDb1(brand, model, minPrice, maxPrice);
    }
    
    @GetMapping("/zapateria2")
    public List<Shoes> getAllDb2(
        @RequestParam(required = false) String brand,
        @RequestParam(required = false) String model,
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice
    ) {
    return shoesAggregatorService.getAllDb2(brand, model, minPrice, maxPrice);
    }

    @GetMapping("/zapateria3")
    public List<Shoes> getAllDb3(
        @RequestParam(required = false) String brand,
        @RequestParam(required = false) String model,
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice
    ) {
    return shoesAggregatorService.getAllDb3(brand, model, minPrice, maxPrice);
    }

}