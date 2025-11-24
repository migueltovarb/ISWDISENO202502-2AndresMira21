package com.prestamos.deportivos.service;

import com.prestamos.deportivos.model.*;
import com.prestamos.deportivos.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InventarioService {
    private final EquipoDeportivoRepository equipoRepo;
    private final HistorialInventarioRepository historialRepo;

    public void decrementarInventario(String equipoId, int cantidad, String reservaId) {
        EquipoDeportivo equipo = equipoRepo.findById(equipoId).orElseThrow();
        int cantidadAnterior = equipo.getCantidadDisponible();
        int cantidadNueva = cantidadAnterior - cantidad;

        equipo.setCantidadDisponible(cantidadNueva);
        equipoRepo.save(equipo);

        // Registrar movimiento
        historialRepo.save(HistorialInventario.builder()
                .equipoId(equipoId)
                .tipoMovimiento("PRESTAMO")
                .cantidadAnterior(cantidadAnterior)
                .cantidadNueva(cantidadNueva)
                .reservaId(reservaId)
                .fecha(LocalDateTime.now())
                .descripcion("Prestamo de equipo")
                .build());
    }

    // HU-007: Actualizacion automatica de inventario al devolver
    public void incrementarInventario(String equipoId, int cantidad, String reservaId, String desc) {
        EquipoDeportivo equipo = equipoRepo.findById(equipoId).orElseThrow();
        int cantidadAnterior = equipo.getCantidadDisponible();
        int cantidadNueva = cantidadAnterior + cantidad;

        equipo.setCantidadDisponible(cantidadNueva);
        equipoRepo.save(equipo);

        // Registrar movimiento
        historialRepo.save(HistorialInventario.builder()
                .equipoId(equipoId)
                .tipoMovimiento("DEVOLUCION")
                .cantidadAnterior(cantidadAnterior)
                .cantidadNueva(cantidadNueva)
                .reservaId(reservaId)
                .fecha(LocalDateTime.now())
                .descripcion(desc)
                .build());
    }
}
