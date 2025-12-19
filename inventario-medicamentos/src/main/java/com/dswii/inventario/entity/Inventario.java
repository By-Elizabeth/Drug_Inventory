package com.dswii.inventario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventarios",
        uniqueConstraints = @UniqueConstraint(columnNames = {"sede_id","medicamento_id"}))
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "sede_id")
    private Sede sede;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

    @Column(nullable = false)
    private Integer stockActual;

    @Column(nullable = false)
    private Integer stockMinimo;
}
