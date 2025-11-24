package com.prestamos.deportivos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "reservas")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Reserva {
    @Id
    private String id;
    private String estudianteId;
    private String estudianteNombre;
    private String equipoId;
    private String equipoNombre;
    private int cantidad;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaRetiroProgramada;
    private LocalDateTime fechaDevolucionProgramada;
    private LocalDateTime fechaDevolucionReal;
    private String estado; // ACTIVO, DEVUELTO
    private String estadoEquipo; // BUEN_ESTADO, DANADO, PERDIDO
    private String descripcionDano;
}
