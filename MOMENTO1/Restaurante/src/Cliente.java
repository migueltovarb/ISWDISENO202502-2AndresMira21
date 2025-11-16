public class Cliente {
    private String nombre;
    private String numeroContacto;

    public Cliente(String nombre, String numeroContacto) {
        this.nombre = nombre;
        this.numeroContacto = numeroContacto;
    }

    public Cliente(){}

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public void registrar(){
        System.out.println("Registrando cliente");
    }

    @Override
    public String toString(){
        return "Cliente[nombre = "+nombre+", numeroContacto = "+numeroContacto+"]";
    }


}
