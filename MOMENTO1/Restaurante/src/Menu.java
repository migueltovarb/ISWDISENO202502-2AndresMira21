import java.util.List;

public class Menu {

    private List<Plato> platos;

    public Menu(List<Plato> platos) {
        this.platos = platos;
    }
    public Menu(){}

    public List<Plato> getPlatos() {
        return platos;
    }
    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }

    @Override
    public String toString(){
        return "Menu[platos = "+platos+"]";
    }

}
