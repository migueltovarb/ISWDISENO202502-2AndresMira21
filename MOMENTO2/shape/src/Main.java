//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Circulo:");
        Circle circle = new Circle(5.5, "red", false);
        System.out.println(circle.toString());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimetro: " + circle.getPerimeter());

        System.out.println("\nRectangulo:");
        Rectangle rectangle = new Rectangle(2.0, 4.0, "blue", true);
        System.out.println(rectangle.toString());
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimetro: " + rectangle.getPerimeter());

        System.out.println("\nCuadrado:");
        Square square = new Square(3.0, "green", true);
        System.out.println(square.toString());
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimetro: " + square.getPerimeter());


    }
}