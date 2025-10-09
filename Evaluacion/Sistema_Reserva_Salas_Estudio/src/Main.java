import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<>();
        List<SalaEstudio> salas = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Sistema de Reserva de Salas de Estudio");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Registrar Sala de Estudio");
            System.out.println("3. Realizar Reserva");
            System.out.println("4. Mostrar Historial de Reservas de un Estudiante");
            System.out.println("5. Mostrar Salas ");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opción:");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Registrar Estudiante");
                    char respuesta;
                    do {
                        System.out.println("Digita el nombre del estudiante:");
                        String nombre = sc.next();
                        System.out.println("Digita el ID del estudiante:");
                        String codigo = sc.next();
                        System.out.println("Digita el programa del estudiante:");
                        String programa = sc.next();
                        Estudiante nuevoEstudiante = new Estudiante(nombre, codigo, programa);
                        if (nuevoEstudiante.validar()) {
                            nuevoEstudiante.registrar();
                            estudiantes.add(nuevoEstudiante);
                        } else {
                            System.out.println("Datos inválidos para el estudiante");
                        }
                        System.out.println("¿Desea registrar otro estudiante? (s/n)");
                        respuesta = sc.next().charAt(0);
                    } while (respuesta == 's' || respuesta == 'S');
                    break;
                case 2:
                    System.out.println("Registrar Sala de Estudio");
                    do {
                        System.out.println("Digita el número de la sala:");
                        int numero = sc.nextInt();
                        System.out.println("Digita la capacidad máxima de la sala:");
                        int capacidadMax = sc.nextInt();
                        SalaEstudio nuevaSala = new SalaEstudio(numero, capacidadMax, true);
                        if (nuevaSala.validar()) {
                            nuevaSala.registrar();
                            salas.add(nuevaSala);
                        } else {
                            System.out.println("Datos inválidos para la sala");
                        }
                        System.out.println("¿Desea registrar otra sala? (s/n)");
                        respuesta = sc.next().charAt(0);
                    } while (respuesta == 's' || respuesta == 'S');

                    break;
                case 3:
                    System.out.println("Realizar Reserva");
                    do {
                        System.out.println(SalaEstudio.mostrarSalasDisponibles(salas));
                        System.out.println("Seleccione el número de la sala a reservar:");
                        int numSala = sc.nextInt();
                        SalaEstudio salaSeleccionada = null;
                        for (SalaEstudio sala : salas) {
                            if (sala.getNumero() == numSala) {
                                salaSeleccionada = sala;
                            }
                        }
                        if (salaSeleccionada == null) {
                            System.out.println("Sala no encontrada.");
                            break;
                        }
                        System.out.println("Digite el codigo del estudiante que realiza la reserva:");
                        String codigoEstudiante = sc.next();
                        Estudiante estudianteSeleccionado = null;
                        for (Estudiante est : estudiantes) {
                            if (est.getCodigo().equals(codigoEstudiante)) {
                                estudianteSeleccionado = est;
                            }
                        }
                        if (estudianteSeleccionado == null) {
                            System.out.println("Estudiante no encontrado.");
                            break;
                        }
                        System.out.println("Ingrese la fecha y hora de la reserva (formato: yyyy-MM-dd HH:mm):");
                        String fechaStr = sc.next() + " " + sc.next();
                        Date fechaReserva;
                        try {
                            fechaReserva = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").parse(fechaStr);
                        } catch (Exception e) {
                            System.out.println("Formato de fecha inválido.");
                            break;
                        }
                        Reserva nuevaReserva = new Reserva(estudianteSeleccionado, salaSeleccionada, fechaReserva);
                        if (nuevaReserva.validar(reservas) && nuevaReserva.reservar()) {
                            estudianteSeleccionado.agregarReserva(nuevaReserva);
                            salaSeleccionada.agregarReserva(nuevaReserva);
                            reservas.add(nuevaReserva);
                        }
                        System.out.println("¿Desea realizar otra reserva? (s/n)");
                        respuesta = sc.next().charAt(0);
                    } while (respuesta == 's' || respuesta == 'S');
                    break;
                case 4:
                    System.out.println("Mostrar Historial de Reservas de un Estudiante");
                    System.out.println("Digite el codigo del estudiante:");
                    String codigoEstudiante = sc.next();
                    Estudiante estudianteSeleccionado = null;
                    for (Estudiante est : estudiantes) {
                        if (est.getCodigo().equals(codigoEstudiante)) {
                            estudianteSeleccionado = est;
                        }
                    }
                    if (estudianteSeleccionado != null) {
                        estudianteSeleccionado.mostrarHistorialReservas();
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Mostrar Salas");
                    SalaEstudio.mostrarSalasDisponibles(salas);
                    break;
                case 6:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while(opcion != 6);

    }
}