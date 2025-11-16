import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        //Fabrica chevrolet = new Fabrica();

        List <Planta> listaPlantas = new ArrayList<Planta>();

        Llanta llantaPasto = new Llanta(17f, "Pista");
        Chasis chasisPasto = new Chasis(500f, Material.ACERO);
        Color colorPasto = Color.AZUL;

        Planta plantaPasto = new Planta(llantaPasto, chasisPasto, colorPasto);
        listaPlantas.add(plantaPasto);

        Llanta llantaIpiales = new Llanta(15f, "Todo Terreno");
        Chasis chasisIpiales = new Chasis(550f, Material.ALUMINIO);
        Color colorIpiales = Color.ROJO;

        Planta plantaIpiales = new Planta(llantaIpiales, chasisIpiales, colorIpiales);
        listaPlantas.add(plantaIpiales);

        for(int i=1;i<=100;i++){
            Carro NuevoCarroPasto = plantaPasto.fabricar();
            System.out.println(NuevoCarroPasto);

            Carro NuevoCarroIpiales = plantaIpiales.fabricar();
            System.out.println(NuevoCarroIpiales);
        }
    }
}
