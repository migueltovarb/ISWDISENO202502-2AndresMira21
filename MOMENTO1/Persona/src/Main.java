import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Ingrese los datos de la persona ===");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();

        System.out.print("Sexo (H/M): ");
        char sexo = scanner.next().toUpperCase().charAt(0);

        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();

        System.out.print("Altura (m): ");
        double altura = scanner.nextDouble();

        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);

        Persona persona2 = new Persona(nombre, edad, sexo);

        Persona persona3 = new Persona();
        persona3.setNombre("Juan Pérez");
        persona3.setEdad(30);
        persona3.setSexo('H');
        persona3.setPeso(75.5);
        persona3.setAltura(1.75);

        System.out.println("========================================");
        System.out.println("PERSONA 1");
        System.out.println("========================================");
        System.out.println(persona1.toString());
        comprobarPesoIdeal(persona1);
        comprobarMayoriaEdad(persona1);
        System.out.println();

        System.out.println("========================================");
        System.out.println("PERSONA 2");
        System.out.println("========================================");
        System.out.println(persona2.toString());
        comprobarPesoIdeal(persona2);
        comprobarMayoriaEdad(persona2);
        System.out.println();

        System.out.println("========================================");
        System.out.println("PERSONA 3");
        System.out.println("========================================");
        System.out.println(persona3.toString());
        comprobarPesoIdeal(persona3);
        comprobarMayoriaEdad(persona3);
        System.out.println();

        scanner.close();
    }

    private static void comprobarPesoIdeal(Persona persona) {
        int resultado = persona.calcularIMC();

        if (resultado == -1) {
            System.out.println("Estado: Está por debajo de su peso ideal");
        } else if (resultado == 0) {
            System.out.println("Estado: Está en su peso ideal");
        } else {
            System.out.println("Estado: Tiene sobrepeso");
        }
    }

    private static void comprobarMayoriaEdad(Persona persona) {
        if (persona.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
    }
}