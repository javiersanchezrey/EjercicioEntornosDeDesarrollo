package EjercicioPractico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * CLASE PRINCIPAL: Gestiona el flujo del programa.
 	* Cumple el Principio de Responsabilidad Única (Investigación): 
 		* Esta clase solo se encarga de la interacción con el usuario.
 */

public class Principal {
	
    // Principio 1 (Unidad): Nombres con sentido. "lector" indica claramente su función.
	
    static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ArrayList<Vehiculo> flota = new ArrayList<Vehiculo>();
        boolean salir = false;

        do {
        	
            System.out.println("\n=== SISTEMA DE GESTIÓN DE ALQUILER ===");
            System.out.println("1. Registrar nuevo vehículo");
            System.out.println("2. Buscar vehículos por categoría");
            System.out.println("3. Añadir revisión de mantenimiento");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            // Principio 4 (Unidad): Uso de excepciones en lugar de códigos de error.
            	// Beneficio: El programa no se cierra si el usuario introduce una letra por error.
            
            int opcion = -1;
            
            try {
            	
                opcion = Integer.parseInt(lector.readLine());
                
            } catch (NumberFormatException e) {
                System.err.println("Error: Debe introducir un número entero.");
            }

            switch (opcion) {
            
                case 1:
                    registrarVehiculo(flota);
                break;
                    
                case 2:
                    buscarPorCategoria(flota);
                break;
                    
                case 3:
                    gestionarMantenimiento(flota);
                break;
                
                case 4:
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                break;
                    
                default:
                    System.out.println("Opción no válida.");
            }
            
        } while (!salir);
    }

    // Principio 2 (Unidad): Funciones de tamaño reducido. 
    	// Beneficio: Facilita la lectura y el mantenimiento al no tener un main gigante.
    
    private static void registrarVehiculo(ArrayList<Vehiculo> flota) {
    	
        System.out.println("=== REGISTRO DE VEHÍCULO ===");
        
        		Vehiculo v = new Vehiculo();
        			v.pedirDatos(flota);
        
        		flota.add(v);
    }

    // Principio 3 (Unidad): Hacer una sola cosa. 
    	// Esta función solo se encarga de filtrar y mostrar, delegando la lógica de impresión al objeto.
    
    private static void buscarPorCategoria(ArrayList<Vehiculo> flota) throws IOException {
    	
        System.out.print("Introduce la categoría (Turismo, SUV, Deportivo): ");
        	String categoria = lector.readLine();
        	
        	boolean encontrado = false;

        for (Vehiculo vehiculo : flota) {
        	
            // Principio 8 (Investigación): Ley de Demeter. 
            	// Beneficio: Reducimos el acoplamiento al no pedirle todos los datos al objeto, sino pedirle que se muestre él mismo.
        	
            if (vehiculo.getCategoria().equalsIgnoreCase(categoria)) {
                vehiculo.mostrarFicha();
                	encontrado = true;
            }
        }
        
        
        if (!encontrado) {
        	System.out.println("No hay vehículos en esa categoría.");
        }
    }

    private static void gestionarMantenimiento(ArrayList<Vehiculo> flota) throws IOException {
    	
        System.out.print("ID del vehículo: ");
        
        int idABuscar = -1;
        
        try {
            idABuscar = Integer.parseInt(lector.readLine());
            
        } catch (Exception e) { 
        	return; 
        }

        boolean encontrado = false;
        
        for (Vehiculo vehiculo : flota) {
        	
            if (vehiculo.getId() == idABuscar) {
            	
                encontrado = true;
                	
                	System.out.print("Descripción del mantenimiento: ");
                		String detalle = lector.readLine();
                		
                if (vehiculo.registrarRevision(detalle)) {
                	System.out.println("Mantenimiento registrado con éxito.");
                	
                } else {
                	System.out.println("ERROR: Historial lleno (Máx 4 revisiones).");
                }
                    
            }
        }
        
        
        if (!encontrado) {
        	System.out.println("Vehículo no encontrado.");
        }
    }
}