package com.crud.vehiculos.service;

import com.crud.vehiculos.model.Vehiculo;
import com.crud.vehiculos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    // Crear un vehículo
    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    // Obtener todos los vehículos
    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return vehiculoRepository.findAll();
    }

    // Obtener vehículo por ID
    public Optional<Vehiculo> obtenerVehiculoPorId(String id) {
        return vehiculoRepository.findById(id);
    }

    // Actualizar vehículo
    public Vehiculo actualizarVehiculo(String id, Vehiculo vehiculoActualizado) {
        Optional<Vehiculo> vehiculoExistente = vehiculoRepository.findById(id);

        if (vehiculoExistente.isPresent()) {
            Vehiculo vehiculo = vehiculoExistente.get();
            vehiculo.setMarca(vehiculoActualizado.getMarca());
            vehiculo.setModelo(vehiculoActualizado.getModelo());
            vehiculo.setAnio(vehiculoActualizado.getAnio());
            vehiculo.setColor(vehiculoActualizado.getColor());
            vehiculo.setPrecio(vehiculoActualizado.getPrecio());
            vehiculo.setPlaca(vehiculoActualizado.getPlaca());
            vehiculo.setTipo(vehiculoActualizado.getTipo());
            return vehiculoRepository.save(vehiculo);
        }

        return null;
    }

    // Eliminar vehículo
    public boolean eliminarVehiculo(String id) {
        if (vehiculoRepository.existsById(id)) {
            vehiculoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Buscar por marca
    public List<Vehiculo> buscarPorMarca(String marca) {
        return vehiculoRepository.findByMarca(marca);
    }

    // Buscar por rango de precio
    public List<Vehiculo> buscarPorRangoPrecio(Double min, Double max) {
        return vehiculoRepository.findByPrecioBetween(min, max);
    }
}