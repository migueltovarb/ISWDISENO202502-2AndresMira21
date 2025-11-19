package com.crud.vehiculos.repository;

import com.crud.vehiculos.model.Vehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehiculoRepository extends MongoRepository<Vehiculo, String> {

    // Métodos de búsqueda personalizados
    List<Vehiculo> findByMarca(String marca);
    List<Vehiculo> findByMarcaAndModelo(String marca, String modelo);
    List<Vehiculo> findByAnio(Integer anio);
    List<Vehiculo> findByPrecioBetween(Double precioMin, Double precioMax);
    Vehiculo findByPlaca(String placa);
}