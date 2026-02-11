package Ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
		 // Principio 1 (Unidad): Nombres con sentido. "lector" indica claramente su función.
		
	    static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

	    public static void main(String[] args) throws IOException {
	    	
	        ArrayList<Videojuego> biblioteca = new ArrayList<Videojuego>();
	        
	        boolean salir = false;

	        do {
	        	
	            System.out.println("\n=== SISTEMA DE GESTIÓN DE VIDEOJUEGOS ===");
	            System.out.println("1. Registrar nuevo videojuego");
	            System.out.println("2. Buscar videojuegos por género");
	            System.out.println("3. Añadir actualización al videojuego");
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
	                    registrarVideojuego(biblioteca);
	                break;
	                    
	                case 2:
	                    buscarPorGenero(biblioteca);
	                break;
	                    
	                case 3:
	                    gestionarActualizaciones(biblioteca);
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
	    
	    private static void registrarVideojuego(ArrayList<Videojuego> biblioteca) {
	    	
	        System.out.println("=== REGISTRO DE VIDEOJUEGO ===");
	        
	        Videojuego v = new Videojuego();
	        v.pedirDatos(biblioteca);
	        
	        biblioteca.add(v);
	    }

	    // Principio 3 (Unidad): Hacer una sola cosa.
	    // Esta función solo se encarga de filtrar y mostrar,
	    // delegando la lógica de impresión al objeto.
	    
	    private static void buscarPorGenero(ArrayList<Videojuego> biblioteca) throws IOException {
	    	
	        System.out.print("Introduce el género (Acción, RPG, Deportes): ");
	        String genero = lector.readLine();
	        	
	        boolean encontrado = false;

	        for (Videojuego videojuego : biblioteca) {
	        	
	            // Principio 8 (Investigación): Ley de Demeter.
	            // Beneficio: Reducimos el acoplamiento al no pedirle todos los datos al objeto,
	            // sino pedirle que se muestre él mismo.
	        	
	            if (videojuego.getGenero().equalsIgnoreCase(genero)) {
	                videojuego.mostrarFicha();
	                encontrado = true;
	            }
	        }
	        
	        if (!encontrado) {
	            System.out.println("No hay videojuegos en ese género.");
	        }
	    }

	    private static void gestionarActualizaciones(ArrayList<Videojuego> biblioteca) throws IOException {
	    	
	        System.out.print("ID del videojuego: ");
	        
	        int idABuscar = -1;
	        
	        try {
	            idABuscar = Integer.parseInt(lector.readLine());
	        } catch (Exception e) { 
	            return; 
	        }

        boolean encontrado = false;
        
        for (Videojuego videojuego : biblioteca) {
        	
            if (videojuego.getId() == idABuscar) {
            	
                encontrado = true;
               	
                System.out.print("Descripción de la actualización: ");
                String detalle = lector.readLine();
                		
                if (videojuego.registrarActualizacion(detalle)) {
                    System.out.println("Actualización registrada con éxito.");
                } else {
                    System.out.println("ERROR: Historial lleno (Máx 4 actualizaciones).");
               }
            }
        }
        
        if (!encontrado) {
            System.out.println("Videojuego no encontrado.");
        }
    }
}
