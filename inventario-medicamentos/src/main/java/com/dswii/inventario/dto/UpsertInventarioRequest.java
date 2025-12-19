package com.dswii.inventario.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpsertInventarioRequest {
    @NotNull
    private Long sedeId;

    @NotNull
    private Long medicamentoId;

    @NotNull @Min(0)
    private Integer stockActual;

    @NotNull @Min(0)
    private Integer stockMinimo;
}
