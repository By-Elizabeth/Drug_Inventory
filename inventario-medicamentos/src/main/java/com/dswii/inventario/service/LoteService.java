package com.dswii.inventario.service;

import com.dswii.inventario.dto.CreateLoteRequest;
import com.dswii.inventario.entity.Lote;
import com.dswii.inventario.entity.Medicamento;
import com.dswii.inventario.exception.NotFoundException;
import com.dswii.inventario.repository.LoteRepository;
import com.dswii.inventario.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoteService {
    private final LoteRepository loteRepository;
    private final MedicamentoRepository medicamentoRepository;

    public LoteService(LoteRepository loteRepository, MedicamentoRepository medicamentoRepository) {
        this.loteRepository = loteRepository;
        this.medicamentoRepository = medicamentoRepository;
    }

    public Lote create(CreateLoteRequest req) {
        Medicamento med = medicamentoRepository.findById(req.getMedicamentoId())
                .orElseThrow(() -> new NotFoundException("Medicamento no encontrado: " + req.getMedicamentoId()));

        Lote l = Lote.builder()
                .codigo(req.getCodigo())
                .fechaCaducidad(req.getFechaCaducidad())
                .medicamento(med)
                .build();
        return loteRepository.save(l);
    }

    public List<Lote> list() {
        return loteRepository.findAll();
    }

    public Lote get(Long id) {
        return loteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lote no encontrado: " + id));
    }

    public void delete(Long id) {
        if (!loteRepository.existsById(id)) {
            throw new NotFoundException("Lote no encontrado: " + id);
        }
        loteRepository.deleteById(id);
    }

    public List<Lote> lotesPorCaducar(LocalDate desde, LocalDate hasta) {
        return loteRepository.findByFechaCaducidadBetween(desde, hasta);
    }
}
