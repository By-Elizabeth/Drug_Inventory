package com.dswii.inventario.service;

import com.dswii.inventario.dto.CreateSedeRequest;
import com.dswii.inventario.entity.Sede;
import com.dswii.inventario.exception.NotFoundException;
import com.dswii.inventario.repository.SedeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeService {
    private final SedeRepository sedeRepository;

    public SedeService(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    public Sede create(CreateSedeRequest req) {
        Sede s = Sede.builder()
                .nombre(req.getNombre())
                .direccion(req.getDireccion())
                .build();
        return sedeRepository.save(s);
    }

    public List<Sede> list() {
        return sedeRepository.findAll();
    }

    public Sede get(Long id) {
        return sedeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sede no encontrada: " + id));
    }

    public Sede update(Long id, CreateSedeRequest req) {
        Sede s = get(id);
        s.setNombre(req.getNombre());
        s.setDireccion(req.getDireccion());
        return sedeRepository.save(s);
    }

    public void delete(Long id) {
        if (!sedeRepository.existsById(id)) {
            throw new NotFoundException("Sede no encontrada: " + id);
        }
        sedeRepository.deleteById(id);
    }
}
