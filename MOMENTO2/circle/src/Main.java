//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Circulo");

        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2.5, "blue");

        System.out.println(circle1.toString());
        System.out.println("Area del circulo 1" + circle1.getArea());

        System.out.println(circle2.toString());
        System.out.println("Area del circulo 2" + circle2.getArea());

        circle1.setRadius(3.0);
        circle1.setColor("green");
        System.out.println("Circulo 1 modificado: " + circle1.toString());
        System.out.println("Area del circulo 1 modificado: " + circle1.getArea());

        System.out.println("\nCilindro");
        Cylinder cylinder1 = new Cylinder();
        Cylinder cylinder2 = new Cylinder(2.0, 5.0, "yellow");

        System.out.println(cylinder1.toString());
        System.out.println("Area del cilindro 1: " + cylinder1.getArea());
        System.out.println("Volumen del cilindro 1: " + cylinder1.getVolume());

        System.out.println(cylinder2.toString());
        System.out.println("Area del cilindro 2: " + cylinder2.getArea());
        System.out.println("Volumen del cilindro 2: " + cylinder2.getVolume());

        cylinder1.setRadius(4.0);
        cylinder1.setHeight(10.0);
        cylinder1.setColor("purple");
        System.out.println("Cilindro 1 modificado: " + cylinder1.toString());
        System.out.println("Area del cilindro 1 modificado: " + cylinder1.getArea());
        System.out.println("Volumen del cilindro 1 modificado: " + cylinder1.getVolume());

        Circle circle3 = new Cylinder(3.0, 7.0, "orange");
        System.out.println("\nCilindro como Circulo:");
        System.out.println(circle3.toString());
        System.out.println("Area del cilindro como circulo: " + circle3.getArea());
        if (circle3 instanceof Cylinder) {
            Cylinder cylinder3 = (Cylinder) circle3;
            System.out.println("Volumen del cilindro como circulo: " + cylinder3.getVolume());
        }


    }
}