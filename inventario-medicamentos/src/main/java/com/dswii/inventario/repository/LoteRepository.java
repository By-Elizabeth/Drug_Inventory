package com.dswii.inventario.repository;

import com.dswii.inventario.entity.Lote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoteRepository extends JpaRepository<Lote, Long> {
    List<Lote> findByFechaCaducidadBetween(LocalDate desde, LocalDate hasta);
}
