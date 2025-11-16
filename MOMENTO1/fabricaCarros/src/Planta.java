import java.util.ArrayList;
import java.util.List;

public class Planta {
    private Llanta llanta;
    private Chasis chasis;
    private Color color;

    public Planta(Llanta llanta, Chasis chasis, Color color){
        this.llanta = llanta;
        this.chasis = chasis;
        this.color = color;
    }

    public void setLlanta(Llanta llanta) {
        this.llanta = llanta;
    }

    public Llanta getLlanta() {
        return llanta;
    }

    public Chasis getChasis() {
        return chasis;
    }

    public void setChasis(Chasis chasis) {
        this.chasis = chasis;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Carro fabricar(){
        List<Llanta> llantasDelCarro = new ArrayList<Llanta>();

        for(int i=1;i<=5;i++){
            llantasDelCarro.add(llanta);
        }

        Chasis chasisDelCarro = chasis;

        Color colorDelCarro = color;

        Carro nuevoCarro = new Carro(llantasDelCarro, chasisDelCarro, colorDelCarro);
        return nuevoCarro;
    }

    public Llanta fabricarLLanta(){
        return new Llanta(llanta.getTamanio(), llanta.getTipo());
    }

    public Chasis fabricarChasis(){
        return new Chasis(chasis.getPeso(), chasis.getMaterial());
    }
}
