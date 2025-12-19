package com.dswii.inventario.controller;

import com.dswii.inventario.dto.CreateSedeRequest;
import com.dswii.inventario.entity.Sede;
import com.dswii.inventario.service.SedeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
@CrossOrigin
public class SedeController {

    private final SedeService sedeService;

    public SedeController(SedeService sedeService) {
        this.sedeService = sedeService;
    }

    @PostMapping
    public ResponseEntity<Sede> create(@Valid @RequestBody CreateSedeRequest req) {
        return ResponseEntity.ok(sedeService.create(req));
    }

    @GetMapping
    public ResponseEntity<List<Sede>> list() {
        return ResponseEntity.ok(sedeService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sede> get(@PathVariable Long id) {
        return ResponseEntity.ok(sedeService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sede> update(@PathVariable Long id, @Valid @RequestBody CreateSedeRequest req) {
        return ResponseEntity.ok(sedeService.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sedeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
