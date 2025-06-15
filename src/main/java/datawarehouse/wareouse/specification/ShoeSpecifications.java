package datawarehouse.wareouse.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import datawarehouse.wareouse.entity.Shoes;
import jakarta.persistence.criteria.Predicate;

public class ShoeSpecifications {
    // public static Specification<Shoes> withFilters(String brand, String color, Double minPrice, Double maxPrice) {
    //     return (root, query, cb) -> {
    //         List<Predicate> predicates = new ArrayList<>();
    //         if (brand != null) predicates.add(cb.equal(root.get("brand"), brand));
    //         if (color != null) predicates.add(cb.equal(root.get("color"), color));
    //         if (minPrice != null) predicates.add(cb.ge(root.get("price"), minPrice));
    //         if (maxPrice != null) predicates.add(cb.le(root.get("price"), maxPrice));
    //         return cb.and(predicates.toArray(new Predicate[0]));
    //     };
    // }

    public static Specification<Shoes> withFilters(String brand, String color, Double minPrice, Double maxPrice) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            
            if (brand != null) {
                predicates.add(cb.like(
                    cb.lower(root.get("brand")),
                    "%" + brand.toLowerCase() + "%"
                ));
            }
    
            if (color != null) {
                predicates.add(cb.like(
                    cb.lower(root.get("color")),
                    "%" + color.toLowerCase() + "%"
                ));
            }
    
            if (minPrice != null) {
                predicates.add(cb.ge(root.get("price"), minPrice));
            }
    
            if (maxPrice != null) {
                predicates.add(cb.le(root.get("price"), maxPrice));
            }
    
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}