package com.dswii.inventario.service;

import com.dswii.inventario.dto.CreateMedicamentoRequest;
import com.dswii.inventario.entity.Medicamento;
import com.dswii.inventario.exception.NotFoundException;
import com.dswii.inventario.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {
    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public Medicamento create(CreateMedicamentoRequest req) {
        Medicamento m = Medicamento.builder()
                .nombre(req.getNombre())
                .descripcion(req.getDescripcion())
                .unidadMedida(req.getUnidadMedida())
                .build();
        return medicamentoRepository.save(m);
    }

    public List<Medicamento> list() {
        return medicamentoRepository.findAll();
    }

    public Medicamento get(Long id) {
        return medicamentoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Medicamento no encontrado: " + id));
    }

    public Medicamento update(Long id, CreateMedicamentoRequest req) {
        Medicamento m = get(id);
        m.setNombre(req.getNombre());
        m.setDescripcion(req.getDescripcion());
        m.setUnidadMedida(req.getUnidadMedida());
        return medicamentoRepository.save(m);
    }

    public void delete(Long id) {
        if (!medicamentoRepository.existsById(id)) {
            throw new NotFoundException("Medicamento no encontrado: " + id);
        }
        medicamentoRepository.deleteById(id);
    }
}
