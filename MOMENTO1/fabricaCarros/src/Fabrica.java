import java.util.List;

public class Fabrica {
    private String nombre;
    private List<Planta> plantas;

    public Fabrica(String nombre, List<Planta> plantas){
        this.nombre = nombre;
        this.plantas = plantas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Planta> getPlantas() {
        return plantas;
    }

    public void setPlantas(List<Planta> plantas) {
        this.plantas = plantas;
    }

    @Override
    public String toString(){
        return "Fabrica[nombre = "+nombre+", Planta = "+plantas+"]";
    }
}
