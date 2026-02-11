package Ejercicio_Entornos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//Fecha de Nacimiento
			public static int fechaNacimiento(int añoNacimiento) {
				int edadUsuario = 2025 - añoNacimiento;
				System.out.println("Tu edad es: " + edadUsuario);
					return edadUsuario;
			}
	// Opción 1.1: Crear nuevo usuario
				public static void crearNuevoUsuario() throws IOException {	
					System.out.println("1. Crear Nuevo Usuario");
							//Nombre Usuario		
						System.out.println("Introduce tu nombre");
							String nombreUsuario = br.readLine();	
						System.out.println("Introduce el año de nacimiento.");
						boolean  numero = true;	
						while(numero) {
							try {
								int añoNacimiento = Integer.parseInt(br.readLine()); 
								  while (añoNacimiento < 1900 || añoNacimiento > 2025) {
										System.out.println("Lo siento pero tu edad es incorrecta. Podrías poner un año correcto.");											
										añoNacimiento = Integer.parseInt(br.readLine());
							}		
							System.out.println("¿Cuál es tu plataforma plataforma? (PC, PlayStation, Xbox o Nintendo)");
								String plataformaFavorita = br.readLine();	
									while (!plataformaFavorita.equalsIgnoreCase("PC") && !plataformaFavorita.equalsIgnoreCase("PlayStation") && !plataformaFavorita.equalsIgnoreCase("Xbox") && !plataformaFavorita.equalsIgnoreCase("Nintendo")) {	
									System.err.println("Lo siento pero esa plataforma no la reconocesmos, ¿Podrías volver a escribir alguna de las del ejemplo?");		
									plataformaFavorita = br.readLine();	
						}
							System.out.println("¿Tienes suscripción premium?");		
								char suscripcionPremium = br.readLine().toLowerCase().charAt(0);
							String idUsuario = nombreUsuario.substring(0, 3) + "GAME" + añoNacimiento;
							System.out.println("Tu ID de Usuario es: " + idUsuario);	
			//Edad Usuario
							int edadUsuario = fechaNacimiento(añoNacimiento);		
			//Tipo de Usuario
							if(edadUsuario >= 0 && edadUsuario <= 17) {
								System.out.println("Eres un jugador 'Junior Game'");			
							} else if (edadUsuario >= 18 && edadUsuario <= 30) {
								System.out.println("Eres un jugador 'Pro Gamer'");
							}else {
								System.out.println("Eres un jugador 'Master Gamer'");			
							}
			//Plataforma Favorita
							System.out.println("Tu plataforma favorita es: " + plataformaFavorita);	
			//Premium o no
							if (suscripcionPremium == 's') {
								System.out.println("Felicidades, Eres PREMIUM.");			
							} else {
								System.out.println("No eres Premium, Lo siento.");		
							}			
							numero = false;	
						} catch (NumberFormatException e){
										System.err.println("Error: No se aceptan letras.");
						}	
				}
			}
	// Opción 1.2: Calcular edad del usuario
				public static void calcularEdadUsuario() throws NumberFormatException, IOException {
					System.out.println("2. Calcular Edad del Usuario");
					boolean  numero = true;
				while(numero) {
						try {
							System.out.println("¿Cuál es tu año de Nacimiento?");
							int añoNacimiento = Integer.parseInt(br.readLine());
			//Edad Usuario
							while (añoNacimiento < 1920 || añoNacimiento > 2025) {
								System.err.println("Lo siento pero la fecha introducida es inválida. Repita un fecha correcta.");
								añoNacimiento = Integer.parseInt(br.readLine());
							}
							int edadUsuario = fechaNacimiento(añoNacimiento);
							System.out.println("El año de nacimiento es: " + añoNacimiento);
			//PEGI
							if (edadUsuario >= 18) {
								System.out.println("Eres mayor de edad por lo que puedes jugar con la etiqueta PEGI 18.");
							} else if (edadUsuario >= 16 && edadUsuario < 18) {
								System.out.println("Puedes jugar con la etiqueta PEGI 16.");
							} else if (edadUsuario >= 12 && edadUsuario < 16) {
								System.out.println("Puedes jugar con la etiqueta PEGI 12.");
							} else if (edadUsuario >= 7 && edadUsuario < 12) {
								System.out.println("Puedes jugar con la etiqueta PEGI 7.");
							} else {
								System.out.println("Puedes jugar con la etiqueta PEGI 3.");
							} 
							numero = false;
						} catch (NumberFormatException e){
							System.err.println("Error: No se aceptan letras.");
						}
				}	
				}
	//OPCIÓN 2: CATALOGO DE JUEGOS
			public static void juegosBiblioteca() throws IOException{
					System.out.println("1. Añadir juegos a la Bibilioteca");
					System.out.println("¿Cuántos juegos quieres añadir?");
						int numeroJuegos = Integer.parseInt(br.readLine());
					double dineroTotalGastado = 0;
					for (int i = 0; i < numeroJuegos; i++) {
						System.out.println("¿Cuál es el nombre del " + (i+1) + "º juego que quieres añadir?");
							String nombreJuego = br.readLine();
						System.out.println("¿Cuál es el tamaño de "  + nombreJuego + "? ");
							int tamañoJuego = Integer.parseInt(br.readLine());
						System.out.println("¿Cuál es el precio de "  + nombreJuego + "?");
							double precioJuego = Double.parseDouble(br.readLine());	
						System.out.println("El nombre del " + (i+1) + "º juego es: " + nombreJuego + " su tamaño es de " + tamañoJuego + " GB y el precio es de " + precioJuego + "€.");
						dineroTotalGastado += precioJuego;
					}
						System.out.println("El dinero total gastado es de: " + dineroTotalGastado + "€.");
				}
	// Opción 2.2. Calcular espacio total ocupado
			public static void calcularMemoria() throws IOException {
					System.out.println("2. Calcular espacio total ocupado");
					System.out.println("¿Cuál es el espacio que tiene disponible en su ordenador?");
						int espacioDisponible = Integer.parseInt(br.readLine());
						while (espacioDisponible <= 0) {
							System.err.println("Error, lo siento pero no puedes tener una capacidad Negativa, revisa tu espacio disponible.");
							espacioDisponible = Integer.parseInt(br.readLine());
						}
					System.out.println("¿Cuántos juegos quieres instalar?");
						int numeroJuegosInstalar = Integer.parseInt(br.readLine());
						int tamañoJuego = 0;
						int tamañoTotalJuegos = 0;
						for (int i = 0; i < numeroJuegosInstalar && tamañoTotalJuegos < espacioDisponible; i++) {
							System.out.println("¿Cuál es el tamaño del " + (i+1) + "º juego en GB?");
								tamañoJuego = Integer.parseInt(br.readLine());
								while (tamañoJuego <= 0) {
									System.err.println("Lo siento pero los juegos siempre ocupan espacio, revisa cuanto espacio ocupan.");
									tamañoJuego = Integer.parseInt(br.readLine());
								}
							tamañoTotalJuegos += tamañoJuego;
						}
						int gbSobrantes = espacioDisponible - tamañoTotalJuegos;
						if (tamañoTotalJuegos > espacioDisponible) {
							System.out.println("Lo siento, pero no tienes sufienciente capacidad para instalar todos los juegos");
						} else if (espacioDisponible > tamañoTotalJuegos){
							System.out.println("Felicidades has podido instalar todos los juegos y todavía te sobran " + gbSobrantes + " GB.");	
						} else if (espacioDisponible == tamañoTotalJuegos) {
							System.out.println("Ya has completado los GB que tenias de capacidad, no puedes seguir instalando juegos.");
						}	
			}
	// OPCIÓN 3: SISTEMA DE VALORACIONES
				public static void valorarSagaJuego() throws IOException {
					System.out.println("3. Valorar Saga Completa");
					System.out.println("¿Cuál es el Nombre del Juego que quieres valorar?");
					String nombreJuego = br.readLine();
						System.out.println("¿Cuantos usuarios van a valorar este Videojuego?");
					int numeroUsuarios = 0;
					boolean todoOK = false;
					while (!todoOK) {
						try {
							numeroUsuarios = Integer.parseInt(br.readLine());
							if (numeroUsuarios > 0) {
								todoOK = true;
							} else {
								System.err.println("Error: el número de usuarios debe ser mayor que 0.");
							}
						} catch (NumberFormatException e){
							System.err.println("Error: El numero de usuario debe ser superior a 0, y no se aceptan letras.");
						}
					}
					double notaUsuariosFinal = 0;
					for ( int i = 0; i < numeroUsuarios; i++) {
						boolean notaValida = false;
						double notaUsuarios = 0;
					while (!notaValida) {
					try {
							System.out.println("La valoración del " + (i+1) + "º usuario es:");
						if (notaUsuarios >= 0 && notaUsuarios <= 10) {
							notaUsuarios = Double.parseDouble(br.readLine());
								System.out.println("La nota introducida es: " + notaUsuarios);
							notaValida = true;	
						}
						while (notaUsuarios < 0 || notaUsuarios > 10){
							System.err.println("Lo siento pero la nota introducida es invalida. \nRepita la nota.");
							notaUsuarios = Double.parseDouble(br.readLine());
						}	
					} catch (NumberFormatException e){
						System.err.println("Error, no se pueden introducir letras.");
					}
						notaUsuariosFinal += notaUsuarios;
					} 
					}
					double notaMediaJuego = notaUsuariosFinal / numeroUsuarios;
					System.out.println("La media de la saga es de: " + notaMediaJuego);
					if (notaMediaJuego >= 9.5 && notaMediaJuego <= 10) {
						System.out.println("El videojuego es una OBRA MAESTRA");
					}else if (notaMediaJuego >= 8.4 && notaMediaJuego < 9.5) {
						System.out.println("El videojuego es una EXCELENTE");
					}else if (notaMediaJuego >= 7 && notaMediaJuego < 8.4) {
						System.out.println("El videojuego es una BUENO");
					}else if (notaMediaJuego >= 5 && notaMediaJuego < 7) {
						System.out.println("El videojuego es una ACEPTABLE");
					}else if (notaMediaJuego >= 0 && notaMediaJuego < 5) {
						System.out.println("El videojuego es una DECEPCIONANTE");
					} else {
						System.out.println("Lo siento pero no se ha recogido correctamente tu nota.");
					}
				}
	//OPCIÓN 5: CALCULADORA DE DESCUENTOS
				public static void calculadoraPrecios() throws NumberFormatException, IOException {
					System.out.println("Introduce el precio del juego.");
						int precio = Integer.parseInt(br.readLine());
					System.out.println("¿Este juego tiene descuento?");
						char respuesta = br.readLine().toLowerCase().charAt(0);
						double precioFinal = 0;
					if (respuesta == 's') {
						System.out.println("¿Cuál es el descuento de este juego?");
							int descuento = Integer.parseInt(br.readLine());
							
							while (descuento < 0 || descuento > 100) {
								System.err.println("Lo siento, pero no puede haber un descuento como el que has indicado.");
								descuento = Integer.parseInt(br.readLine());
							}
							precioFinal = calcularPrecioFinal(precio, descuento);
						System.out.println("El precio del juego es: " + precio + " €, pero con el descuento se te queda en :" + precioFinal + " €.");
					} else {
						double precioSinDescuento = precio;
							System.out.println("El precio del juego es: " + precioSinDescuento + " €, ya que no tiene ningún descuento.");
					}
				}
				public static double calcularPrecioFinal(double precio, double descuento) {
					double precioFinal = precio - (precio * (descuento / 100.0));
					    if (precioFinal > 15) {
					        	precioFinal = calcularPrecioFinal(precioFinal, 5);
					    }
				    return precioFinal;
				}
	//Código Principal
					public static void main(String[] args) throws NumberFormatException, IOException{
							boolean salir = false;
							System.out.println("=== BIENVENIDO A Control de Biblioteca Parental ===");
							do {
							System.out.println("\n--- Biblioteca Calasanz Games ---");
							System.out.println("1. Gestión de Usuarios");
							System.out.println("2. Catálogo de Juegos");
							System.out.println("3. Sistema de Valoraciones");
							System.out.println("4. Calculadora de Descuentos");
							System.out.println("5. Salir");
							System.out.print("Elige una opción: ");
							int opcion = 0;
							try {
								opcion = Integer.parseInt(br.readLine());
							} catch (NumberFormatException e){
								System.err.println("Error: Solo se pueden elegir numero del 1 al 6, no se pueden seleccionar letras.");		
							}
							switch (opcion) {
			//CASE 1
							case 1:
						//SUBMENÚ 1
					boolean salirSubmenu1 = false;		
					do {		
					System.out.println("\n--- Gestion de Usuarios ---");
					System.out.println("1. Crear nuevo Usuario");
					System.out.println("2. Calcular la edad del Usuario");
					System.out.println("3. Volver al menú principal");
					System.out.print("Estas en el Submenú, Elige una Opción: ");		
					int submenu1 = 0;
						try {
							submenu1 = Integer.parseInt(br.readLine());
						} catch (NumberFormatException e){
							System.err.println("Error: Solo se pueden elegir numero del 1 al 3, no se pueden seleccionar letras.");
						}
					switch (submenu1) {
					case 1:
						crearNuevoUsuario();
					break;
					case 2:
						calcularEdadUsuario();
					break;	
					case 3:
						salirSubmenu1 = true;
						System.out.println("¡Volviendo al menú Principal!");
						break;
				default:
					System.err.println("Opcion no válida.");
				}
				} while (!salirSubmenu1);
						break;
			//CASE 2	
						case 2:
							System.out.println("2. Catálogo de Juegos");
							//SUBMENÚ 2
						boolean salirSubmenu2 = false;
					do {				
						System.out.println("\n--- Gestion de Usuarios ---");								
						System.out.println("1. Añadir juegos a la Biblioteca");
						System.out.println("2. Calcular espacio total ocupado");
						System.out.println("3. Volver al menú principal");
						System.out.print("Estas en el Submenú, Elige una Opción: ");					
				int submenu2 = 0;			
					try {
						submenu2 = Integer.parseInt(br.readLine());
					} catch (NumberFormatException e){
						System.err.println("Error: Solo se pueden elegir numero del 1 al 3, no se pueden seleccionar letras.");
					}
				switch (submenu2) {
				case 1:		
					juegosBiblioteca();
				break;	
				case 2:
					calcularMemoria();	
				break;	
				case 3:
					salirSubmenu2 = true;
					System.out.println("¡Volviendo al menú Principal!");	
				break;
				default:
					System.err.println("Opcion no válida.");	
				}
				} while (!salirSubmenu2);
							break;
				case 4:	
					calculadoraPrecios();
				break;
				case 5:
					salir = true;
					System.out.println("¡Saliendo del Programa!");
				break;
				default:
					System.err.println("Opción no válida");
				}
		} 
				while(!salir);
	}	
}