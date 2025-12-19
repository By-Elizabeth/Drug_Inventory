package com.dswii.inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InventarioAlertaResponse {
    private Long inventarioId;
    private Long sedeId;
    private String sedeNombre;
    private Long medicamentoId;
    private String medicamentoNombre;
    private Integer stockActual;
    private Integer stockMinimo;
    private String alerta;
}
