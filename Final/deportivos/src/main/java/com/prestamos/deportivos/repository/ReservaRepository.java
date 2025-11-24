package com.prestamos.deportivos.repository;

import com.prestamos.deportivos.model.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, String> {
    List<Reserva> findByEstudianteId(String estudianteId);
    List<Reserva> findByEstado(String estado);
    long countByEstudianteIdAndEstado(String estudianteId, String estado);
}