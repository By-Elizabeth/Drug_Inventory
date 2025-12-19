package com.dswii.inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class LoteCaducidadResponse {
    private Long loteId;
    private String codigo;
    private Long medicamentoId;
    private String medicamentoNombre;
    private LocalDate fechaCaducidad;
    private long diasParaCaducar;
}
