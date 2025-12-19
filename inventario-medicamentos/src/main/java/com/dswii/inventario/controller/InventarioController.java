package com.dswii.inventario.controller;

import com.dswii.inventario.dto.InventarioAlertaResponse;
import com.dswii.inventario.dto.UpsertInventarioRequest;
import com.dswii.inventario.entity.Inventario;
import com.dswii.inventario.service.InventarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
@CrossOrigin
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @PostMapping("/upsert")
    public ResponseEntity<Inventario> upsert(@Valid @RequestBody UpsertInventarioRequest req) {
        return ResponseEntity.ok(inventarioService.upsert(req));
    }

    @GetMapping
    public ResponseEntity<List<Inventario>> list() {
        return ResponseEntity.ok(inventarioService.list());
    }

    @GetMapping("/sede/{sedeId}")
    public ResponseEntity<List<Inventario>> listBySede(@PathVariable Long sedeId) {
        return ResponseEntity.ok(inventarioService.listBySede(sedeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> get(@PathVariable Long id) {
        return ResponseEntity.ok(inventarioService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        inventarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/alertas/stock-bajo")
    public ResponseEntity<List<InventarioAlertaResponse>> alertasStockBajo() {
        return ResponseEntity.ok(inventarioService.alertasStockBajo());
    }
}
