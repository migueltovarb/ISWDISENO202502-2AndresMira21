package com.prestamos.deportivos.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class DevolucionRequest {
    @NotBlank(message = "El ID de la reserva es obligatorio")
    private String reservaId;

    @NotBlank(message = "El estado del equipo es obligatorio")
    private String estadoEquipo; // BUEN_ESTADO, DANADO, PERDIDO

    private String descripcionDano;
}
