package Ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Videojuego {
		
	    // Principio 7 (Investigación): Encapsulamiento.
	    // Beneficio: Protege la integridad de los datos evitando modificaciones externas accidentales.
		
	    private int id;
	    
	    private String titulo;
	    
	    private String genero;
	    
	    private int horasJugadas;
	    
	    private String[] actualizaciones = new String[4];
	    
	    private int numActualizaciones = 0;

	    
	    public void pedirDatos(ArrayList<Videojuego> biblioteca) {
	    	
	        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

	        // Validación de ID único (Estructura idéntica al código original)
	        
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
	            
	        } while (idRepetido(biblioteca, id) || id < 1 || id > 999);

	        
	        try {
	            System.out.print("Introduce Título del Videojuego: ");
	            titulo = leer.readLine();

	            do {
	                System.out.print("Género (Acción, RPG, Deportes): ");
	                genero = leer.readLine();
	                
	            } while (!genero.equalsIgnoreCase("Acción") && 
	                     !genero.equalsIgnoreCase("RPG") && 
	                     !genero.equalsIgnoreCase("Deportes"));

	            System.out.print("Horas jugadas: ");
	            horasJugadas = Integer.parseInt(leer.readLine());
		            		
	        } catch (IOException e) {
	            System.out.println("Error al capturar datos.");
	        }
	    }
	    

	    private boolean idRepetido(ArrayList<Videojuego> biblioteca, int idUsuario) {
	    	
	        for (Videojuego v : biblioteca) {
	            if (v.getId() == idUsuario) {
	                return true;
	            }
	        }
	        return false;
	    }

	    
	    // Principio 5 (Unidad): Evitar comentarios obvios.
	    // El código es auto-explicativo: el nombre del método dice exactamente qué hace.
	    
	    public void mostrarFicha() {
	    	
	        System.out.println("\n--- VIDEOJUEGO ID: " + id + " ---");
	        System.out.println("Título: " + titulo + " | Género: " + genero);
	        System.out.println("Horas jugadas: " + horasJugadas + " h");
	        
	        if (numActualizaciones > 0) {
	            System.out.print("Actualizaciones: ");
	            
	            for (int i = 0; i < numActualizaciones; i++) {
	                System.out.print("[" + actualizaciones[i] + "] ");
	            }
	            
	            System.out.println();
	        }
	    }
	    

	    public boolean registrarActualizacion(String detalle) {
	    	
	        if (numActualizaciones < 4) {
	        	
	            actualizaciones[numActualizaciones] = detalle;
	            numActualizaciones++;
	            
	            return true;
	        }
	        
	        return false;
	    }
	    

	    // Getters necesarios para cumplir con el encapsulamiento
	    
	    public int getId() { 
	        return id; 
	    }
	    
	    
	    public String getGenero() { 
	        return genero; 
	    }
	}
