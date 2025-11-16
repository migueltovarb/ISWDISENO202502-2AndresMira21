public class Llanta {
    private float tamanio;
    private String tipo;

    public Llanta(float tamanio, String tipo){
        this.tamanio = tamanio;
        this.tipo = tipo;
    }

    public float getTamanio() {
        return tamanio;
    }

    public void setTamanio(float tamanio) {
        this.tamanio = tamanio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "Llanta[tamaño = "+tamanio+", tipo = "+tipo+"]";
    }
}
