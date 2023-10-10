/*
 * Escriba un programa que te permita jugar a la “primitiva”.  Para facilitar la labor de depuración de errores, cada vez que el usuario introduzca un número se mostrará el boleto con los números que debe acertar.

Las condiciones del ejercicio son:

El programa debe generar una secuencia de números no repetidos como si fuera un boleto (9 números; mayores de 10 y menores de 100).

12 21 35 46 88 72 94 49 27

Después el usuario escribirá un numero: 

Si existe, mostrará lo siguiente: 

12 21 35 XX 88 72 94 49 27

Si no existe, mostrará lo siguiente:

Número 78 no existe

12 21 35 46 88 72 94 49 27

Se puede salir de la aplicación cuando el usuario escriba 0.

En caso de tener todos los números tachados, se mostrará:

Te ha tocado la primitiva. Eres millonario.

Existirá un número máximo de 15 intentos para acertar los números del boleto.
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	// Método que devuelve el número de aciertos con el boleto premiado
	public static int comprobar(int[] premiado) {
		int aciertos = 0;
		for (int i = 0; i < premiado.length; i++) {
			if (premiado[i] == 0) {
				aciertos++;
			}
		}
		return aciertos;
	}
	
	// Método que muestra el número premiado
	public static void mostrar(int[] boleto) {
		for ( int i = 0; i < boleto.length; i++ ) {
			if (boleto[i] >= 10) {
				System.out.print(boleto[i] + " ");
			} else {
				System.out.print("XX ");
			}
		}
		System.out.println();
	}
	
	// Método que devuelve un valor de 1 si el boleto contiene el número indicado
	// y 0 si no lo contiene
	public static int contiene (int[] premiado, int numero) {
		int existe = 0, i = 0;

		while(existe == 0 && i < premiado.length) {
			if (premiado[i] != 0 && numero > 9 && numero < 101 && premiado[i] == numero) {
				existe = 1;
			}
			i++;
		}
		return existe;
	}
	
	// Método para generar un valor entero entre 10 y 100
	public static int generarAleatorio () {
		return (int)Math.round(Math.random()*90) + 10;
	}
	
	// Método que genera y devuelve un array con los números premiados. Crea el boleto premiado sin repetición
	public static int[] generarPremiado (int numeros) {
		int contiene = 1, aux = 0;
		int[] premiado = new int[numeros];
		
		for ( int i = 0; i < numeros; i++ ) {
			contiene = 1;
			while (contiene != 0) {
				aux = generarAleatorio();
				contiene = contiene(premiado, aux);
			}
			premiado[i] = aux;
		}
		
		return premiado;
	}
	
	// Método que comprueba si un número se encuentra entre los premiados y lo cambia por 0
	public static int[] comprobarExistencia (int[] premiado, int numero) {
		int existe = 0, i = 0;
		while (i < premiado.length && existe != 1) {
			if (premiado[i] == numero) {
				existe = 1;
				premiado[i] = 0;
			}
			i++;
		}
		if (existe == 0) {
			System.out.println("El " + numero + " no existe");
		} 
		return premiado;
	}
	
	// Método que copia el array premiado y lo devuelve
	public static int[] copiarPremiado (int[] premiado, int[] boleto) {
		for ( int i = 0; i < premiado.length; i++ ) {
			boleto[i] = premiado[i];
		}
		return boleto;
	}
	
	// Método para conseguir un valor entero del usuario
	// Si el valor no se encuentra entre 10 y 100, lo pide de nuevo
	// También comprueba si ya se ha introducido un valor
	public static int getNumero (Scanner scanner, List<Integer> probados) {
		int numero = 1;
		
		while (numero < 10 && numero > 0 || numero > 100) {
			System.out.print("Nuevo numero: ");
			numero = scanner.nextInt(); 
			if (probados.contains(numero)) {
				System.out.println("Ya has introducido ese dato");
				numero = 1;
			}
		}
		
		return numero;
	}
	
	public static void main(String[] args) {
		int numeros = 9, numero = 0, aciertos = 0, intentos = 0;
		int[] premiado = new int [numeros];
		int[] coincidencias = new int[numeros];
		List<Integer> probados = new ArrayList<Integer>();
		Boolean fin = false;
		Scanner scanner = new Scanner(System.in);
		
		premiado = generarPremiado(numeros);
		
		mostrar(premiado);
		coincidencias = copiarPremiado(premiado, coincidencias);
		
		while (!fin && intentos < 15) {
			numero = getNumero(scanner, probados);
			probados.add(numero);
			if (numero == 0) {
				fin = true;
			} else {
				coincidencias = comprobarExistencia(coincidencias, numero);
				System.out.println();
				mostrar(coincidencias);
				aciertos = comprobar(coincidencias);
				if (aciertos == 9) {
					fin = true;
					System.out.println("Te ha tocado la primitiva. Eres millonario.");
				}
				intentos++;
			}
		}
		if (aciertos < 9) {
			System.out.println("Suerte la proxima!");
		}
		scanner.close();
	}

}
