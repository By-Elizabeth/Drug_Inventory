package com.dswii.inventario.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateMedicamentoRequest {
    @NotBlank
    private String nombre;
    private String descripcion;
    @NotBlank
    private String unidadMedida;
}
