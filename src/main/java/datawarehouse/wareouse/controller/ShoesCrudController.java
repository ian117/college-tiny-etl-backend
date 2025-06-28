package datawarehouse.wareouse.controller;

import datawarehouse.wareouse.entity.Shoes;
import datawarehouse.wareouse.service.ShoesCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zapatos/crud")
public class ShoesCrudController {

    private final ShoesCrudService crudService;

    @Autowired
    public ShoesCrudController(ShoesCrudService crudService) {
        this.crudService = crudService;
    }

    // GET all (solo DB1)
    @GetMapping
    public List<Shoes> getAll() {
        return crudService.findAll();
    }

    // GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Shoes> getById(@PathVariable Long id) {
        return crudService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - crear nuevo zapato
    @PostMapping
    public Shoes create(@RequestBody Shoes shoe) {
        return crudService.save(shoe);
    }

    // PUT - actualizar por ID
    @PutMapping("/{id}")
    public ResponseEntity<Shoes> update(@PathVariable Long id, @RequestBody Shoes shoe) {
        Shoes updated = crudService.update(id, shoe);
        return updated != null ?
                ResponseEntity.ok(updated) :
                ResponseEntity.notFound().build();
    }

    // DELETE - eliminar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (crudService.existsById(id)) {
            crudService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
