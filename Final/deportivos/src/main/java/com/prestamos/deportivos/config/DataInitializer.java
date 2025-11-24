package com.prestamos.deportivos.config;

import com.prestamos.deportivos.model.*;
import com.prestamos.deportivos.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final EquipoDeportivoRepository equipoRepo;

    @Override
    public void run(String... args) {
        // Crear equipos de ejemplo si no existen
        if (equipoRepo.count() == 0) {
            equipoRepo.save(EquipoDeportivo.builder()
                    .codigo("EQ-001").nombre("Balon de Futbol").tipo("Futbol")
                    .descripcion("Balon profesional tamano 5")
                    .cantidadTotal(10).cantidadDisponible(10)
                    .fechaRegistro(LocalDateTime.now()).build());

            equipoRepo.save(EquipoDeportivo.builder()
                    .codigo("EQ-002").nombre("Balon de Baloncesto").tipo("Baloncesto")
                    .descripcion("Balon oficial NBA")
                    .cantidadTotal(8).cantidadDisponible(8)
                    .fechaRegistro(LocalDateTime.now()).build());

            equipoRepo.save(EquipoDeportivo.builder()
                    .codigo("EQ-003").nombre("Raqueta de Tenis").tipo("Tenis")
                    .descripcion("Raqueta Wilson profesional")
                    .cantidadTotal(6).cantidadDisponible(6)
                    .fechaRegistro(LocalDateTime.now()).build());

            System.out.println("Equipos de ejemplo creados");
        }
    }
}