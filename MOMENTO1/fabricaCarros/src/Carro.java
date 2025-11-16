import java.util.List;

public class Carro {
    private List<Llanta> llanta;
    private Chasis chasis;
    private Color color;

    public Carro(List<Llanta> llanta, Chasis chasis, Color color){
        this.llanta = llanta;
        this.chasis = chasis;
        this.color = color;
    }

    public List<Llanta> getLlanta() {
        return llanta;
    }

    public void setLlanta(List<Llanta> llanta) {
        this.llanta = llanta;
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

    @Override
    public String toString(){
        return "Carro[llanta = "+llanta+", chasis = "+chasis+", color = "+color+"]";
    }
}
