import java.util.ArrayList;
import java.util.List;

public class SalaEstudio {
    public int numero;
    public int capacidadMax;
    public boolean disponibilidad;

    public List<Reserva> reservas = new ArrayList<>();

    public SalaEstudio() {}

    public SalaEstudio(int numero, int capacidadMax, boolean disponibilidad) {
        this.numero = numero;
        this.capacidadMax = capacidadMax;
        this.disponibilidad = disponibilidad;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }
    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void registrar() {
        System.out.println("Sala registrada: " + this.numero);
    }

    public static Object mostrarSalasDisponibles(List<SalaEstudio> salas) {
        System.out.println("Salas disponibles:");
        for (SalaEstudio sala : salas) {
            System.out.println(sala);
        }
        return null;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }


    public boolean validar() {
        return numero > 0 && capacidadMax > 0;
    }

    @Override
    public String toString() {
        return "SalaEstudio[ numero=" + numero + ", capacidadMax=" + capacidadMax + ", disponibilidad=" + disponibilidad + ']';
    }
}
