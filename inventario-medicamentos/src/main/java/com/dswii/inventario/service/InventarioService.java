package com.dswii.inventario.service;

import com.dswii.inventario.dto.InventarioAlertaResponse;
import com.dswii.inventario.dto.UpsertInventarioRequest;
import com.dswii.inventario.entity.Inventario;
import com.dswii.inventario.entity.Medicamento;
import com.dswii.inventario.entity.Sede;
import com.dswii.inventario.exception.BadRequestException;
import com.dswii.inventario.exception.NotFoundException;
import com.dswii.inventario.repository.InventarioRepository;
import com.dswii.inventario.repository.MedicamentoRepository;
import com.dswii.inventario.repository.SedeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventarioService {
    private final InventarioRepository inventarioRepository;
    private final SedeRepository sedeRepository;
    private final MedicamentoRepository medicamentoRepository;

    public InventarioService(InventarioRepository inventarioRepository, SedeRepository sedeRepository, MedicamentoRepository medicamentoRepository) {
        this.inventarioRepository = inventarioRepository;
        this.sedeRepository = sedeRepository;
        this.medicamentoRepository = medicamentoRepository;
    }

    public Inventario upsert(UpsertInventarioRequest req) {
        if (req.getStockActual() < 0 || req.getStockMinimo() < 0) {
            throw new BadRequestException("Stock no puede ser negativo");
        }

        Sede sede = sedeRepository.findById(req.getSedeId())
                .orElseThrow(() -> new NotFoundException("Sede no encontrada: " + req.getSedeId()));
        Medicamento med = medicamentoRepository.findById(req.getMedicamentoId())
                .orElseThrow(() -> new NotFoundException("Medicamento no encontrado: " + req.getMedicamentoId()));

        Inventario inv = inventarioRepository.findBySedeIdAndMedicamentoId(req.getSedeId(), req.getMedicamentoId())
                .orElse(Inventario.builder().sede(sede).medicamento(med).build());

        inv.setStockActual(req.getStockActual());
        inv.setStockMinimo(req.getStockMinimo());
        return inventarioRepository.save(inv);
    }

    public List<Inventario> list() {
        return inventarioRepository.findAll();
    }

    public List<Inventario> listBySede(Long sedeId) {
        return inventarioRepository.findBySedeId(sedeId);
    }

    public Inventario get(Long id) {
        return inventarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Inventario no encontrado: " + id));
    }

    public void delete(Long id) {
        if (!inventarioRepository.existsById(id)) {
            throw new NotFoundException("Inventario no encontrado: " + id);
        }
        inventarioRepository.deleteById(id);
    }

    public List<InventarioAlertaResponse> alertasStockBajo() {
        return inventarioRepository.findAll()
                .stream()
                .filter(inv -> inv.getStockActual() <= inv.getStockMinimo())
                .map(inv -> new InventarioAlertaResponse(
                        inv.getId(),
                        inv.getSede().getId(),
                        inv.getSede().getNombre(),
                        inv.getMedicamento().getId(),
                        inv.getMedicamento().getNombre(),
                        inv.getStockActual(),
                        inv.getStockMinimo(),
                        "STOCK_BAJO"
                ))
                .collect(Collectors.toList());
    }
}
