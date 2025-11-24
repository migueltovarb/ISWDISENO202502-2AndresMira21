package com.prestamos.deportivos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "usuarios")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Usuario {
    @Id
    private String id;
    private String nombre;

    @Indexed(unique = true)
    private String codigoInstitucional;

    @Indexed(unique = true)
    private String correo;

    private String password;
    private LocalDateTime fechaRegistro;
}