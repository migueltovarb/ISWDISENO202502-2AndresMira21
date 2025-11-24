package com.prestamos.deportivos.controller;


import com.prestamos.deportivos.dto.*;
import com.prestamos.deportivos.model.Usuario;
import com.prestamos.deportivos.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<ApiResponse<Usuario>> registrar(
            @Valid @RequestBody RegistroEstudianteRequest request) {
        ApiResponse<Usuario> response = usuarioService.registrarEstudiante(request);
        return response.isExito()
                ? ResponseEntity.status(HttpStatus.CREATED).body(response)
                : ResponseEntity.badRequest().body(response);
    }
}