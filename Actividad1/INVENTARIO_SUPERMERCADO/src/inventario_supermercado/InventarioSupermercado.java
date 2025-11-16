import java.util.Scanner;

public class InventarioSupermercado {

	public static void main(String[] args) {
		final int MAX_PRODUCTOS = 5;
		
		String[] nombre_producto = new String[MAX_PRODUCTOS];
		int[] cantidad_disponible = new int[MAX_PRODUCTOS];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<MAX_PRODUCTOS;i++) {
			System.out.println(i+1+ ". Digita el nombre del producto");
			nombre_producto[i] = sc.nextLine();
			int cantidad;
			do {
				System.out.println(i+1+". Digita la cantidad del producto");
				cantidad = sc.nextInt();
				if(cantidad < 0) {
					System.out.println("No se permiten cantidades negativas");
				}
			} while(cantidad < 0);
			cantidad_disponible[i] = cantidad;
			sc.nextLine();
		}
			
		
		int respuesta; 
		do {

			System.out.println("Selecciona una opcion");
			System.out.println("1. Mostrar todos los productos");
			System.out.println("2. Buscar un producto por nombre");
			System.out.println("3. Actualizar inventario");
			System.out.println("4. Generar alerta de productos");
			System.out.println("5. Salir");
			
			respuesta = sc.nextInt();
				
			switch(respuesta) {
				
			case 1:

				System.out.println("Inventario");
			    int total = 0;
			    for(int i=0; i<nombre_producto.length; i++) {
			        System.out.println("Producto: " + nombre_producto[i] + ". Cantidad: " + cantidad_disponible[i]);
			        total += cantidad_disponible[i];
			    }
			    System.out.println("TOTAL productos en inventario: " + total);
			    break;
			case 2:
				System.out.println("Digita el nombre del prodcuto ");
				String value = sc.next().toUpperCase();

				for(int i=0; i<nombre_producto.length;i++) {
					if(nombre_producto[i].equalsIgnoreCase(value)) {
						System.out.println("Cantidad del producto "+nombre_producto[i]+": "+cantidad_disponible[i]);
						break;
					}
				}
				break;
			case 3:
				System.out.println("Actualizar Inventario");
			    System.out.print("Digite el nombre del producto: ");
			    String value_act = sc.next();
			    boolean encontrado = false;

			    for(int i=0; i<nombre_producto.length; i++) {
			        if(nombre_producto[i].equalsIgnoreCase(value_act)) {
			            System.out.print("Ingrese la cantidad a modificar (use número negativo para restar): ");
			            int cambio = sc.nextInt();
			            
			            if (cantidad_disponible[i] + cambio < 0) {
			                System.out.println("Error: no puede quedar en negativo.");
			            } else {
			                cantidad_disponible[i] += cambio;
			                System.out.println("Nueva cantidad de " + nombre_producto[i] + ": " + cantidad_disponible[i]);
			            }
			            encontrado = true;
			            break;
			        }
			    }
			    if (!encontrado) {
			        System.out.println("Producto no encontrado.");
			    }
			    break;
			case 4:
				for(int i = 0; i<cantidad_disponible.length;i++) {
					if(cantidad_disponible[i] < 10) {
						System.out.println("El producto "+nombre_producto[i]+" Tiene menos de 10 productos");
					}
				}
				break;
			case 5:
				System.out.println("Saliendo del sistema");
				break;
			default:
				System.out.println("El numero seleccionado no esta disponible");
				break;
			}
			
		} while(respuesta != 5);
		
		sc.close();
		
	}

}
