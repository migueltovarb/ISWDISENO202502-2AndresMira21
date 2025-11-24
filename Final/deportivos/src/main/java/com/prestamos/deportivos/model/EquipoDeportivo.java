package com.prestamos.deportivos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "equipos")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EquipoDeportivo {
    @Id
    private String id;
    private String codigo;
    private String nombre;
    private String tipo;
    private String descripcion;
    private int cantidadTotal;
    private int cantidadDisponible;
    private LocalDateTime fechaRegistro;
}