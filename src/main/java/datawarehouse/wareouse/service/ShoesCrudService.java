package datawarehouse.wareouse.service;

import datawarehouse.wareouse.entity.Shoes;
import datawarehouse.wareouse.repo.db1.ShoesRepo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoesCrudService {

    private final ShoesRepo1 repo1;

    @Autowired
    public ShoesCrudService(ShoesRepo1 repo1) {
        this.repo1 = repo1;
    }

    public List<Shoes> findAll() {
        return repo1.findAll();
    }

    public Optional<Shoes> findById(Long id) {
        return repo1.findById(id);
    }

    public Shoes save(Shoes shoe) {
        // shoe.setId(null); // fuerza a que JPA genere un nuevo ID
        return repo1.save(shoe);
    }

    public void deleteById(Long id) {
        repo1.deleteById(id);
    }

    public Shoes update(Long id, Shoes updatedShoe) {
        return repo1.findById(id).map(shoe -> {
            shoe.setModel(updatedShoe.getModel());
            shoe.setQuantity(updatedShoe.getQuantity());
            shoe.setSize(updatedShoe.getSize());
            shoe.setBrand(updatedShoe.getBrand());
            return repo1.save(shoe);
        }).orElse(null);
    }

    public boolean existsById(Long id) {
        return repo1.existsById(id);
    }
}
