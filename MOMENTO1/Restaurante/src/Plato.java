public class Plato {

    private String nombre;
    private TipoPlato tipoPlato;
    private double precio;

    public Plato(String nombre, TipoPlato tipoPlato, double precio) {
        this.nombre = nombre;
        this.tipoPlato = tipoPlato;
        this.precio = precio;
    }
    public Plato(){}

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoPlato getTipoPlato() {
        return tipoPlato;
    }
    public void setTipoPlato(TipoPlato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void registrar(){
        System.out.println("Registrando plato");
    }

    @Override
    public String toString(){
        return "Plato[nombre = "+nombre+", tipoPlato = "+tipoPlato+", precio = "+precio+"]";
    }

}
