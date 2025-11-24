package com.prestamos.deportivos.service;

import com.prestamos.deportivos.dto.*;
import com.prestamos.deportivos.model.*;
import com.prestamos.deportivos.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepo;
    private final EquipoDeportivoRepository equipoRepo;
    private final UsuarioRepository usuarioRepo;
    private final InventarioService inventarioService;

    public ApiResponse<Reserva> crearReserva(String estudianteId, ReservaRequest req) {
        // Validar usuario
        Usuario estudiante = usuarioRepo.findById(estudianteId).orElse(null);
        if (estudiante == null) {
            return ApiResponse.error("Usuario no encontrado");
        }

        // Validar maximo 3 reservas activas
        long reservasActivas = reservaRepo.countByEstudianteIdAndEstado(estudianteId, "ACTIVO");
        if (reservasActivas >= 3) {
            return ApiResponse.error("Ya tiene 3 reservas activas. No puede crear mas.");
        }

        // Validar equipo
        EquipoDeportivo equipo = equipoRepo.findById(req.getEquipoId()).orElse(null);
        if (equipo == null) {
            return ApiResponse.error("Equipo no encontrado");
        }
        if (equipo.getCantidadDisponible() < req.getCantidad()) {
            return ApiResponse.error("No hay suficientes unidades disponibles");
        }

        // Validar fechas
        LocalDateTime ahora = LocalDateTime.now();
        if (req.getFechaRetiro().isBefore(ahora)) {
            return ApiResponse.error("La fecha de retiro no puede ser en el pasado");
        }
        if (req.getFechaRetiro().isAfter(ahora.plusDays(7))) {
            return ApiResponse.error("Solo puede reservar con maximo 7 dias de anticipacion");
        }
        if (req.getFechaDevolucion().isBefore(req.getFechaRetiro())) {
            return ApiResponse.error("La fecha de devolucion debe ser posterior al retiro");
        }

        // Crear reserva
        Reserva reserva = Reserva.builder()
                .estudianteId(estudianteId)
                .estudianteNombre(estudiante.getNombre())
                .equipoId(equipo.getId())
                .equipoNombre(equipo.getNombre())
                .cantidad(req.getCantidad())
                .fechaSolicitud(LocalDateTime.now())
                .fechaRetiroProgramada(req.getFechaRetiro())
                .fechaDevolucionProgramada(req.getFechaDevolucion())
                .estado("ACTIVO")
                .build();

        reserva = reservaRepo.save(reserva);

        inventarioService.decrementarInventario(equipo.getId(), req.getCantidad(), reserva.getId());

        return ApiResponse.success("Reserva creada exitosamente", reserva);
    }

    public ApiResponse<Reserva> procesarDevolucion(DevolucionRequest req) {
        Reserva reserva = reservaRepo.findById(req.getReservaId()).orElse(null);
        if (reserva == null) {
            return ApiResponse.error("Reserva no encontrada");
        }
        if (!"ACTIVO".equals(reserva.getEstado())) {
            return ApiResponse.error("La reserva no esta activa");
        }

        // Actualizar reserva
        reserva.setEstado("DEVUELTO");
        reserva.setFechaDevolucionReal(LocalDateTime.now());
        reserva.setEstadoEquipo(req.getEstadoEquipo());

        if ("DANADO".equals(req.getEstadoEquipo())) {
            reserva.setDescripcionDano(req.getDescripcionDano());
        }

        reservaRepo.save(reserva);

        if (!"PERDIDO".equals(req.getEstadoEquipo())) {
            String desc = "Devolucion - " + req.getEstadoEquipo();
            inventarioService.incrementarInventario(
                    reserva.getEquipoId(),
                    reserva.getCantidad(),
                    reserva.getId(),
                    desc
            );
        }

        boolean tieneRetraso = LocalDateTime.now().isAfter(reserva.getFechaDevolucionProgramada());
        String mensaje = tieneRetraso ? "Devolucion registrada CON RETRASO" : "Devolucion registrada exitosamente";

        return ApiResponse.success(mensaje, reserva);
    }

    public List<Reserva> obtenerMisReservas(String estudianteId) {
        return reservaRepo.findByEstudianteId(estudianteId);
    }

    public List<Reserva> obtenerReservasActivas() {
        return reservaRepo.findByEstado("ACTIVO");
    }
}