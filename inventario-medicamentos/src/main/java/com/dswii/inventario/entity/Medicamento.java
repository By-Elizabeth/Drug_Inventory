package com.dswii.inventario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicamentos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 140)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false, length = 40)
    private String unidadMedida;
}
