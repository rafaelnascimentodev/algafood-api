package com.dantas.algafood.api.controller;

import com.dantas.algafood.doman.model.Restaurante;
import com.dantas.algafood.doman.servicies.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService service;

    @GetMapping
    public ResponseEntity<List<Restaurante>> findAll() {
        final var obj = service.findAll();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Restaurante> findById(@PathVariable Long id){
        final var obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Restaurante> save(@RequestBody Restaurante restaurante) {
        final var obj = service.save(restaurante);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Restaurante> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Restaurante> update(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        final var update = service.update(id, restaurante);
        return ResponseEntity.ok(update);
    }
}