import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Juan Perez", "123456789");
        Object miCliente = cliente;
        System.out.println(cliente);

        Plato plato1 = new Plato("Ensalada Cesar", TipoPlato.ENTRADA, 10.0);
        Plato plato2 = new Plato("Pollo a la parrilla", TipoPlato.PLATOFUERTE, 20.0);
        Plato plato3 = new Plato("Postre de limon", TipoPlato.POSTRE, 30.0);
        Plato plato4 = new Plato("Jugo de naranja", TipoPlato.BEBIDA, 5.0);

        List<Plato> platosMenu = new ArrayList<Plato>();
        platosMenu.add(plato1);
        platosMenu.add(plato2);
        platosMenu.add(plato3);
        platosMenu.add(plato4);

        Menu miMenu = new Menu(platosMenu);
        System.out.println(miMenu);

        List<Plato> platosPedido = new ArrayList<Plato>();
        platosPedido.add(plato2);
        platosPedido.add(plato3);
        platosPedido.add(plato4);
        Pedido miPedido = new Pedido(platosPedido, cliente);

        System.out.println(miPedido);
        miPedido.mostrarPedido();


    }
}
