package com.prestamos.deportivos.repository;

import com.prestamos.deportivos.model.EquipoDeportivo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EquipoDeportivoRepository extends MongoRepository<EquipoDeportivo, String> {
    List<EquipoDeportivo> findByCantidadDisponibleGreaterThan(int cantidad);
}
