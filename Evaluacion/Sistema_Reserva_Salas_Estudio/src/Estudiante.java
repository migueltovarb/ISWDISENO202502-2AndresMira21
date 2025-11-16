import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    public String nombre;
    public String codigo;
    public String programa;
    public List<Reserva> historialReservas = new ArrayList<>();

    public Estudiante() {}

    public Estudiante(String nombre, String codigo, String programa) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.programa = programa;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrograma() {
        return programa;
    }
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void registrar() {
        System.out.println("Estudiante registrado: " + this.nombre + ", ID: " + this.codigo);
    }

    public void agregarReserva(Reserva reserva) {
        historialReservas.add(reserva);
    }

    public void mostrarHistorialReservas() {
        System.out.println("Historial de reservas para: " + nombre);
        for (Reserva r : historialReservas) {
            System.out.println(r);
        }
    }

    public boolean validar() {
        return nombre != null && !nombre.isEmpty() && codigo != null && !codigo.isEmpty() && programa != null && !programa.isEmpty();
    }

    @Override
    public String toString() {
        return "Estudiante[ nombre=" + nombre + ", id=" + codigo + ", programa=" + programa + ']';
    }
}
