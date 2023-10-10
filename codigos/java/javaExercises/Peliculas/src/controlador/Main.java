package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Pelicula;

public class Main {

	public static void main(String[] args) {
		boolean salir = false;
		int opcion;
		Scanner scanner = new Scanner(System.in);
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		
		listaPelis.add(new Pelicula("Origen", 148, "Leonardo DiCaprio", "espanol"));
		listaPelis.add(new Pelicula("Interstellar", 169, "Matthew McConaughey", "espanol"));
		listaPelis.add(new Pelicula("Skyfall", 143, "Daniel Craig", "espanol"));
		
		
		System.out.println(
				"\n\n1. Insertar pelicula\n" +
				"2. Ver datos de una pelicula\n" +
				"3. Numero de peliculas\n" +
				"4. Imprimir todas las peliculas\n" +
				"5. Salir\n"
				);
		while ( !salir ) {
			System.out.println("\nIntroduzca una opcion");
			opcion = scanner.nextInt();
			if ( opcion < 1 || opcion > 5) {
				System.out.println("La opcion debe estar entre 1 y 5. Se mostrara la 4");
				opcion = 4;
			}
			
			switch(opcion) {

			case 1:
				System.out.println("\033[32m" + "Insertar pelicula: " + "\033[37m");
				
				Pelicula pelicula = new Pelicula();

				String titulo = pelicula.newTitulo();
				int duracion = pelicula.newDuracion();
				String protagonista = pelicula.newProtagonista();
				String idioma = pelicula.newIdioma();
				
				pelicula.setTitulo(titulo);
				pelicula.setDuracion(duracion);
				pelicula.setProtagonista(protagonista);
				pelicula.setIdioma(idioma);
				
				listaPelis.add(pelicula);
				
				break;
			case 2:
				System.out.println("\033[32m" + "Ver datos de la pelicula: " + "\033[37m");
				mostrarLista(listaPelis);
				System.out.println("Introduzca el indice de la pelicula de la que desea conocer la informacion");
				int indice = scanner.nextInt();
				if ( indice < 1 || indice > 5) {
					System.out.println("El indice anadido se encuentra fuera del rango de la lista");
				}
				scanner.nextLine();
				System.out.println(listaPelis.get(indice - 1).toString());
				break;
			case 3:
				System.out.print("\033[32m" + "Numero de peliculas en la lista: " + "\033[37m");
				System.out.println(listaPelis.size());
				break;
			case 4:
				System.out.println("\033[32m" + "Imprimir todas las peliculas: " + "\033[37m");
				mostrarLista(listaPelis);
				break;
			case 5:
				salir = true;
				break;
			}
		}
		
		System.out.println("\033[32m" + "Fin de programa" + "\033[37m");
	}
	
	public static void mostrarLista (List<Pelicula> listaPelis) {
		for ( int i = 0; i < listaPelis.size(); i++) {
			System.out.println(i + 1 + ": " + listaPelis.get(i).getTitulo());
		}
	}

}
