import java.util.Date;
import java.util.List;

public class Reserva {
    public Estudiante estudiante;
    public SalaEstudio sala;
    public Date fecha;

    public Reserva() {}

    public Reserva(Estudiante estudiante, SalaEstudio sala, Date fecha) {
        this.estudiante = estudiante;
        this.sala = sala;
        this.fecha = fecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public SalaEstudio getSala() {
        return sala;
    }
    public void setSala(SalaEstudio sala) {
        this.sala = sala;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean reservar() {
        if (sala.isDisponibilidad()) {
            sala.setDisponibilidad(false);
            System.out.println("Reserva realizada para el estudiante: " + estudiante.getNombre() + " en la sala: " + sala.getNumero() + " para la fecha: " + fecha);
            return true;
        } else {
            System.out.println("La sala " + sala.getNumero() + " no está disponible.");
            return false;
        }
    }

    public boolean validar(List<Reserva> reservasExistentes) {
        if (estudiante == null || sala == null || fecha == null || estudiante.getNombre().isEmpty() || estudiante.getCodigo().isEmpty() || estudiante.getPrograma().isEmpty()) {
            System.out.println("No se permiten campos vacíos en la reserva.");
            return false;
        }
        for (Reserva r : reservasExistentes) {
            if (r.sala.getNumero() == sala.getNumero() && r.fecha.equals(fecha)) {
                System.out.println("La sala ya está reservada en esa fecha y hora.");
                return false;
            }
            if (r.sala.getNumero() == sala.getNumero() && r.estudiante.getCodigo().equals(estudiante.getCodigo()) && r.fecha.equals(fecha)) {
                System.out.println("No se permite duplicar una reserva de la misma sala, mismo estudiante, misma fecha y hora.");
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reserva[ estudiante=" + estudiante + ", sala=" + sala + ", fecha=" + fecha + ']';
    }

}