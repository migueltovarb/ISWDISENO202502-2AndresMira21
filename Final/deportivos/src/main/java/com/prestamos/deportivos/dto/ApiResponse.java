package com.prestamos.deportivos.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ApiResponse<T> {
    private boolean exito;
    private String mensaje;
    private T datos;
    private LocalDateTime timestamp;

    public static <T> ApiResponse<T> success(String mensaje, T datos) {
        return ApiResponse.<T>builder()
                .exito(true).mensaje(mensaje).datos(datos)
                .timestamp(LocalDateTime.now()).build();
    }

    public static <T> ApiResponse<T> error(String mensaje) {
        return ApiResponse.<T>builder()
                .exito(false).mensaje(mensaje)
                .timestamp(LocalDateTime.now()).build();
    }
}