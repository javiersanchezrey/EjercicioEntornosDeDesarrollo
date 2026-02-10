package EjercicioPractico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*** CLASE VEHICULO: Representa los datos de un coche, 
 * Cumple el Principio de Encapsulamiento (Investigación): Los atributos son privados y se accede a ellos mediante métodos controlados. */

public class Vehiculo {
	
    // Principio 7 (Investigación): Encapsulamiento.
    		// Beneficio: Protege la integridad de los datos evitando modificaciones externas accidentales.
	
    private int id;
    
    private String modelo;
    
    private String categoria;
    
    private int kilometraje;
    
    private String[] revisiones = new String[4];
    
    private int numRevisiones = 0;

    public void pedirDatos(ArrayList<Vehiculo> flota) {
    	
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        // Validación de ID único (Estructura idéntica a tu código original)
        
        do {
        	
            try {
            	
                System.out.print("Introduce ID único (1-999): ");
                		id = Integer.parseInt(leer.readLine());
                		
                if (id < 1 || id > 999) {
                		
                		System.out.println("ID fuera de rango.");
                }
                
            } catch (Exception e) {
            		id = -1; 
            	}
            
        } while (idRepetido(flota, id) || id < 1 || id > 999);

        
        try {
        	
            System.out.print("Introduce Marca y Modelo: ");
            		modelo = leer.readLine();

            do {
                System.out.print("Categoría (Turismo, SUV, Deportivo): ");
                		categoria = leer.readLine();
                
            } while (!categoria.equalsIgnoreCase("Turismo") && !categoria.equalsIgnoreCase("SUV") && !categoria.equalsIgnoreCase("Deportivo"));

	            System.out.print("Kilometraje actual: ");
	            		kilometraje = Integer.parseInt(leer.readLine());
	            		
        } catch (IOException e) {
            System.out.println("Error al capturar datos.");
        }
    }
    

    private boolean idRepetido(ArrayList<Vehiculo> flota, int idUsuario) {
    	
        for (Vehiculo v : flota) {
        	
            if (v.getId() == idUsuario) {
            		return true;
            }
        }
        return false;
    }

    // Principio 5 (Unidad): Evitar comentarios obvios.
    		// El código es auto-explicativo: el nombre del método dice exactamente qué hace.
    
    public void mostrarFicha() {
    	
        System.out.println("\n--- COCHE ID: " + id + " ---");
        System.out.println("Modelo: " + modelo + " | Cat: " + categoria);
        System.out.println("Kilometraje: " + kilometraje + " km");
        
        if (numRevisiones > 0) {
            System.out.print("Revisiones: ");
            
            for (int i = 0; i < numRevisiones; i++) System.out.print("[" + revisiones[i] + "] ");
            
            System.out.println();
        }
    }
    

    public boolean registrarRevision(String detalle) {
    	
        if (numRevisiones < 4) {
        	
            revisiones[numRevisiones] = detalle;
            
            		numRevisiones++;
            
            return true;
        }
        
        return false;
    }
    

    // Getters necesarios para cumplir con el encapsulamiento
    
    public int getId() {
    		return id; 
    	}
    
    
    public String getCategoria() { 
    		return categoria; 
    	}
}