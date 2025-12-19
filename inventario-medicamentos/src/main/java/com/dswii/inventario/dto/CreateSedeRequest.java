package com.dswii.inventario.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateSedeRequest {
    @NotBlank
    private String nombre;
    @NotBlank
    private String direccion;
}
