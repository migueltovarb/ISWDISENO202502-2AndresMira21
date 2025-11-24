package com.prestamos.deportivos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "historial_inventario")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class HistorialInventario {
    @Id
    private String id;
    private String equipoId;
    private String tipoMovimiento; // PRESTAMO, DEVOLUCION
    private int cantidadAnterior;
    private int cantidadNueva;
    private String reservaId;
    private LocalDateTime fecha;
    private String descripcion;
}