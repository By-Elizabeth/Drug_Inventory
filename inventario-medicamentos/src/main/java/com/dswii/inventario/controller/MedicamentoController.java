package com.dswii.inventario.controller;

import com.dswii.inventario.dto.CreateMedicamentoRequest;
import com.dswii.inventario.entity.Medicamento;
import com.dswii.inventario.service.MedicamentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
@CrossOrigin
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public ResponseEntity<Medicamento> create(@Valid @RequestBody CreateMedicamentoRequest req) {
        return ResponseEntity.ok(medicamentoService.create(req));
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> list() {
        return ResponseEntity.ok(medicamentoService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> get(@PathVariable Long id) {
        return ResponseEntity.ok(medicamentoService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> update(@PathVariable Long id, @Valid @RequestBody CreateMedicamentoRequest req) {
        return ResponseEntity.ok(medicamentoService.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
