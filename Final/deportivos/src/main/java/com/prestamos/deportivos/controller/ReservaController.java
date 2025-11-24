package com.prestamos.deportivos.controller;

import com.prestamos.deportivos.dto.*;
import com.prestamos.deportivos.model.Reserva;
import com.prestamos.deportivos.service.ReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ApiResponse<Reserva>> crearReserva(
            @Valid @RequestBody ReservaRequest request,
            @RequestHeader("X-Usuario-Id") String estudianteId) {
        ApiResponse<Reserva> response = reservaService.crearReserva(estudianteId, request);
        return response.isExito()
                ? ResponseEntity.status(HttpStatus.CREATED).body(response)
                : ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/mis-reservas")
    public ResponseEntity<ApiResponse<List<Reserva>>> misReservas(
            @RequestHeader("X-Usuario-Id") String estudianteId) {
        List<Reserva> reservas = reservaService.obtenerMisReservas(estudianteId);
        return ResponseEntity.ok(ApiResponse.success("Mis reservas", reservas));
    }

    @GetMapping("/activas")
    public ResponseEntity<ApiResponse<List<Reserva>>> reservasActivas() {
        List<Reserva> reservas = reservaService.obtenerReservasActivas();
        return ResponseEntity.ok(ApiResponse.success("Reservas activas", reservas));
    }

    @PostMapping("/devolucion")
    public ResponseEntity<ApiResponse<Reserva>> procesarDevolucion(
            @Valid @RequestBody DevolucionRequest request) {
        ApiResponse<Reserva> response = reservaService.procesarDevolucion(request);
        return response.isExito()
                ? ResponseEntity.ok(response)
                : ResponseEntity.badRequest().body(response);
    }
}
