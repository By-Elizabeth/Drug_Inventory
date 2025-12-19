package com.dswii.inventario.controller;

import com.dswii.inventario.dto.CreateLoteRequest;
import com.dswii.inventario.dto.LoteCaducidadResponse;
import com.dswii.inventario.entity.Lote;
import com.dswii.inventario.service.LoteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/lotes")
@CrossOrigin
public class LoteController {

    private final LoteService loteService;

    public LoteController(LoteService loteService) {
        this.loteService = loteService;
    }

    @PostMapping
    public ResponseEntity<Lote> create(@Valid @RequestBody CreateLoteRequest req) {
        return ResponseEntity.ok(loteService.create(req));
    }

    @GetMapping
    public ResponseEntity<List<Lote>> list() {
        return ResponseEntity.ok(loteService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> get(@PathVariable Long id) {
        return ResponseEntity.ok(loteService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        loteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Ej: /api/lotes/por-caducar?dias=30
    @GetMapping("/por-caducar")
    public ResponseEntity<List<LoteCaducidadResponse>> porCaducar(@RequestParam(defaultValue = "30") int dias) {
        LocalDate hoy = LocalDate.now();
        LocalDate hasta = hoy.plusDays(Math.max(dias, 0));

        List<LoteCaducidadResponse> resp = loteService.lotesPorCaducar(hoy, hasta)
                .stream()
                .map(l -> new LoteCaducidadResponse(
                        l.getId(),
                        l.getCodigo(),
                        l.getMedicamento().getId(),
                        l.getMedicamento().getNombre(),
                        l.getFechaCaducidad(),
                        ChronoUnit.DAYS.between(hoy, l.getFechaCaducidad())
                ))
                .toList();

        return ResponseEntity.ok(resp);
    }
}
