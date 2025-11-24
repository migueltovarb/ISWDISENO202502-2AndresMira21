package com.prestamos.deportivos.service;

import com.prestamos.deportivos.dto.*;
import com.prestamos.deportivos.model.Usuario;
import com.prestamos.deportivos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder;

    public ApiResponse<Usuario> registrarEstudiante(RegistroEstudianteRequest req) {
        // Validar correo unico
        if (usuarioRepo.existsByCorreo(req.getCorreo())) {
            return ApiResponse.error("El correo ya esta registrado");
        }

        // Validar codigo institucional unico
        if (usuarioRepo.existsByCodigoInstitucional(req.getCodigoInstitucional())) {
            return ApiResponse.error("El codigo institucional ya esta registrado");
        }

        // Crear usuario
        Usuario usuario = Usuario.builder()
                .nombre(req.getNombre())
                .codigoInstitucional(req.getCodigoInstitucional())
                .correo(req.getCorreo().toLowerCase())
                .password(passwordEncoder.encode(req.getPassword()))
                .fechaRegistro(LocalDateTime.now())
                .build();

        usuario = usuarioRepo.save(usuario);
        return ApiResponse.success("Registro exitoso", usuario);
    }

    public Usuario obtenerPorId(String id) {
        return usuarioRepo.findById(id).orElse(null);
    }
}
