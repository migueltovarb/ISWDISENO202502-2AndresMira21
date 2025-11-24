package com.prestamos.deportivos.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class ReservaRequest {
    @NotBlank(message = "El ID del equipo es obligatorio")
    private String equipoId;

    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int cantidad = 1;

    @NotNull(message = "La fecha de retiro es obligatoria")
    private LocalDateTime fechaRetiro;

    @NotNull(message = "La fecha de devolucion es obligatoria")
    private LocalDateTime fechaDevolucion;
}
