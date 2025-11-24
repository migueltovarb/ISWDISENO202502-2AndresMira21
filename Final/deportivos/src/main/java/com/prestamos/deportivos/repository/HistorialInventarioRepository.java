package com.prestamos.deportivos.repository;

import com.prestamos.deportivos.model.HistorialInventario;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface HistorialInventarioRepository extends MongoRepository<HistorialInventario, String> {
    List<HistorialInventario> findByEquipoIdOrderByFechaDesc(String equipoId);
}