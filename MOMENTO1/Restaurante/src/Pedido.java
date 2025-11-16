import java.util.List;

public class Pedido {

    private List<Plato> platos;
    private Cliente cliente;

    public Pedido(List<Plato> platos, Cliente cliente) {
        this.platos = platos;
        this.cliente = cliente;
    }
    public Pedido(){}

    public List<Plato> getPlatos() {
        return platos;
    }
    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void registrar(){
        System.out.println("Registrando pedido");
    }

    public double calcularTotal(){
        double acumular = 0.0;
        for(Plato plato : platos){
            acumular += plato.getPrecio();
        }
        return acumular;
    }

    public void mostrarPedido(){
        System.out.println("Acontinuacion el resumen del pedido");
        for(Plato plato : platos){
            System.out.println(plato);
        }
        System.out.println("Total a pagar: "+calcularTotal());
    }

    @Override
    public String toString(){
        return "Pedido[cliente = "+cliente+", platos = "+platos+"]";
    }
}
