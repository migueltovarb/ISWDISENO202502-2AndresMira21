package com.prestamos.deportivos.controller;

import com.prestamos.deportivos.dto.ApiResponse;
import com.prestamos.deportivos.model.EquipoDeportivo;
import com.prestamos.deportivos.repository.EquipoDeportivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
public class EquipoController {
    private final EquipoDeportivoRepository equipoRepo;

    @GetMapping("/disponibles")
    public ResponseEntity<ApiResponse<List<EquipoDeportivo>>> listarDisponibles() {
        List<EquipoDeportivo> equipos = equipoRepo.findByCantidadDisponibleGreaterThan(0);
        return ResponseEntity.ok(ApiResponse.success("Equipos disponibles", equipos));
    }
}
