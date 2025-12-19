package com.dswii.inventario.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "lotes", indexes = {
        @Index(name = "idx_lote_codigo", columnList = "codigo"),
        @Index(name = "idx_lote_caducidad", columnList = "fechaCaducidad")
})
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String codigo;

    @Column(nullable = false)
    private LocalDate fechaCaducidad;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;
}
