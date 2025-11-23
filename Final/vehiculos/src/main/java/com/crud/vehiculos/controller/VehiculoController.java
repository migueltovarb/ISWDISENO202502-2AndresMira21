package com.crud.vehiculos.controller;

import com.crud.vehiculos.model.Vehiculo;
import com.crud.vehiculos.service.VehiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "*")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    // CREATE - Crear un nuevo vehículo
    @PostMapping
    public ResponseEntity<Vehiculo> crearVehiculo(@Valid @RequestBody Vehiculo vehiculo) {
        Vehiculo nuevoVehiculo = vehiculoService.crearVehiculo(vehiculo);
        return new ResponseEntity<>(nuevoVehiculo, HttpStatus.CREATED);
    }

    // READ - Obtener todos los vehículos
    @GetMapping
    public ResponseEntity<List<Vehiculo>> obtenerTodosLosVehiculos() {
        List<Vehiculo> vehiculos = vehiculoService.obtenerTodosLosVehiculos();
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    // READ - Obtener un vehículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerVehiculoPorId(@PathVariable String id) {
        Optional<Vehiculo> vehiculo = vehiculoService.obtenerVehiculoPorId(id);
        return vehiculo.map(v -> new ResponseEntity<>(v, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // UPDATE - Actualizar un vehículo
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizarVehiculo(
            @PathVariable String id,
            @Valid @RequestBody Vehiculo vehiculo) {
        Vehiculo vehiculoActualizado = vehiculoService.actualizarVehiculo(id, vehiculo);

        if (vehiculoActualizado != null) {
            return new ResponseEntity<>(vehiculoActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE - Eliminar un vehículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVehiculo(@PathVariable String id) {
        boolean eliminado = vehiculoService.eliminarVehiculo(id);

        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Búsqueda por marca
    @GetMapping("/buscar/marca/{marca}")
    public ResponseEntity<List<Vehiculo>> buscarPorMarca(@PathVariable String marca) {
        List<Vehiculo> vehiculos = vehiculoService.buscarPorMarca(marca);
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    // Búsqueda por rango de precio
    @GetMapping("/buscar/precio")
    public ResponseEntity<List<Vehiculo>> buscarPorRangoPrecio(
            @RequestParam Double min,
            @RequestParam Double max) {
        List<Vehiculo> vehiculos = vehiculoService.buscarPorRangoPrecio(min, max);
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }
}