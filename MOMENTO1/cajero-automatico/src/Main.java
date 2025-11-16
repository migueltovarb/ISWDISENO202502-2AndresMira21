import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double SALDO_INICIAL = 1000;
        double saldo = SALDO_INICIAL;

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Cajero Automático ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    System.out.println("Tu saldo actual es: $"+saldo);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double deposito = sc.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    } else {
                        System.out.println("Cantidad inválida. Intente nuevamente.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double retiro = sc.nextDouble();
                    if (retiro > 0) {
                        if (retiro <= saldo) {
                            saldo -= retiro;
                            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                        } else {
                            System.out.println("Fondos insuficientes.");
                        }
                    } else {
                        System.out.println("Cantidad inválida. Intente nuevamente.");
                    }
                    break;
                case 4:
                    System.out.println("Gracias por usar el cajero. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);
        sc.close();

    }

}
