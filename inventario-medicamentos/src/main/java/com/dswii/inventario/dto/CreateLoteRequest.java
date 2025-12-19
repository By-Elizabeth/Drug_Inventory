package com.dswii.inventario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class CreateLoteRequest {
    @NotBlank
    private String codigo;

    @NotNull
    private LocalDate fechaCaducidad;

    @NotNull
    private Long medicamentoId;
}
