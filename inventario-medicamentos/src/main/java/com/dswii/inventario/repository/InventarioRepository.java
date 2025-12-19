package com.dswii.inventario.repository;

import com.dswii.inventario.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    Optional<Inventario> findBySedeIdAndMedicamentoId(Long sedeId, Long medicamentoId);
    List<Inventario> findBySedeId(Long sedeId);
}
