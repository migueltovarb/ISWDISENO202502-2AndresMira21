package com.crud.vehiculos.ui;

import com.crud.vehiculos.model.Vehiculo;
import com.crud.vehiculos.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private VehiculoService vehiculoService;

    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear vehículo");
            System.out.println("2. Listar vehículos");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Actualizar vehículo");
            System.out.println("5. Eliminar vehículo");
            System.out.println("6. Buscar por marca");
            System.out.println("7. Buscar por rango de precio");
            System.out.println("8. Salir");
            String option = scanner.nextLine();

            switch (option.trim()) {
                case "1":
                    crearVehiculo(scanner);
                    break;
                case "2":
                    listarVehiculos();
                    break;
                case "3":
                    buscarPorId(scanner);
                    break;
                case "4":
                    actualizarVehiculo(scanner);
                    break;
                case "5":
                    eliminarVehiculo(scanner);
                    break;
                case "6":
                    buscarPorMarca(scanner);
                    break;
                case "7":
                    buscarPorRangoPrecio(scanner);
                    break;
                case "8":
                    running = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void crearVehiculo(Scanner scanner) {
        try {
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Año: ");
            Integer anio = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Color: ");
            String color = scanner.nextLine();
            System.out.print("Precio: ");
            Double precio = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Placa: ");
            String placa = scanner.nextLine();
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();

            Vehiculo v = new Vehiculo();
            v.setMarca(marca);
            v.setModelo(modelo);
            v.setAnio(anio);
            v.setColor(color);
            v.setPrecio(precio);
            v.setPlaca(placa);
            v.setTipo(tipo);
            Vehiculo creado = vehiculoService.crearVehiculo(v);
            System.out.println("Creado: " + creado.getId());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listarVehiculos() {
        List<Vehiculo> lista = vehiculoService.obtenerTodosLosVehiculos();
        if (lista.isEmpty()) {
            System.out.println("Sin registros");
            return;
        }
        for (Vehiculo v : lista) {
            System.out.println(v.getId() + " | " + v.getMarca() + " " + v.getModelo() + " | " + v.getAnio() + " | " + v.getColor() + " | " + v.getPrecio() + " | " + v.getPlaca() + " | " + v.getTipo());
        }
    }

    private void buscarPorId(Scanner scanner) {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        Optional<Vehiculo> v = vehiculoService.obtenerVehiculoPorId(id.trim());
        if (v.isPresent()) {
            Vehiculo d = v.get();
            System.out.println(d.getId() + " | " + d.getMarca() + " " + d.getModelo() + " | " + d.getAnio() + " | " + d.getColor() + " | " + d.getPrecio() + " | " + d.getPlaca() + " | " + d.getTipo());
        } else {
            System.out.println("No encontrado");
        }
    }

    private void actualizarVehiculo(Scanner scanner) {
        try {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Año: ");
            Integer anio = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Color: ");
            String color = scanner.nextLine();
            System.out.print("Precio: ");
            Double precio = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Placa: ");
            String placa = scanner.nextLine();
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();

            Vehiculo v = new Vehiculo();
            v.setMarca(marca);
            v.setModelo(modelo);
            v.setAnio(anio);
            v.setColor(color);
            v.setPrecio(precio);
            v.setPlaca(placa);
            v.setTipo(tipo);
            Vehiculo actualizado = vehiculoService.actualizarVehiculo(id.trim(), v);
            if (actualizado != null) {
                System.out.println("Actualizado");
            } else {
                System.out.println("No encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void eliminarVehiculo(Scanner scanner) {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        boolean ok = vehiculoService.eliminarVehiculo(id.trim());
        if (ok) {
            System.out.println("Eliminado");
        } else {
            System.out.println("No encontrado");
        }
    }

    private void buscarPorMarca(Scanner scanner) {
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        List<Vehiculo> lista = vehiculoService.buscarPorMarca(marca.trim());
        if (lista.isEmpty()) {
            System.out.println("Sin registros");
            return;
        }
        for (Vehiculo v : lista) {
            System.out.println(v.getId() + " | " + v.getMarca() + " " + v.getModelo() + " | " + v.getAnio() + " | " + v.getColor() + " | " + v.getPrecio() + " | " + v.getPlaca() + " | " + v.getTipo());
        }
    }

    private void buscarPorRangoPrecio(Scanner scanner) {
        try {
            System.out.print("Precio mínimo: ");
            Double min = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Precio máximo: ");
            Double max = Double.parseDouble(scanner.nextLine().trim());
            List<Vehiculo> lista = vehiculoService.buscarPorRangoPrecio(min, max);
            if (lista.isEmpty()) {
                System.out.println("Sin registros");
                return;
            }
            for (Vehiculo v : lista) {
                System.out.println(v.getId() + " | " + v.getMarca() + " " + v.getModelo() + " | " + v.getAnio() + " | " + v.getColor() + " | " + v.getPrecio() + " | " + v.getPlaca() + " | " + v.getTipo());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}