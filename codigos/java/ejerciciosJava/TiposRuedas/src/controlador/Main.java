package controlador;

import modelo.CustomRuedasPista;
import modelo.Ruedas;
import modelo.RuedasPista;
import modelo.RuedasRallie;
import modelo.RuedasKarts;

public class Main {

	public static void main(String[] args) {
		
		String[] nombres = { "Neumaticos de pista: ", "Neumaticos de rallies: ", "Neumaticos de karts: " };
		
		CustomRuedasPista customRuedasPista = new CustomRuedasPista("Michelin", "23/03/2023", 9, "negro", "mojado", 25, 95.4f, "Miguel");
		
		RuedasPista ruedasPista = new RuedasPista("Michelin", "23/03/2023", 9, "negro", "mojado", 25, 95.4f);
		RuedasRallie ruedasRallie = new RuedasRallie("Dunlop", "21/05/2023", 23, "blanco", "seco", 5.7f, 5);
		RuedasKarts ruedasKarts = new RuedasKarts("Michelin", "22/04/2023", 67, "gris", "intermedio", 140);
		
		// Polimorfismo
		Ruedas[] ruedas = new Ruedas[3];
		ruedas[0] = ruedasPista;
		ruedas[1] = ruedasRallie;
		ruedas[2] = ruedasKarts;
		
		// Mostrar informacion de ruedas, dureza e impresion de marca y caducidad en una linea de cada tipo de ruedas
		for ( int i = 0; i < ruedas.length; i++) {
			System.out.println(nombres[i]);
			System.out.println(ruedas[i].toString());
			System.out.println(ruedas[i].checkDureza());
			System.out.println(ruedas[i].marcaCaducidad());
			System.out.println();
		}
		
		System.out.println("_______________________________________________");
		
		// Probar getters y setters
		System.out.println("\n" + nombres[0]);
		System.out.println("Caducidad:\t\t" + ruedasPista.getCaducidad());
		System.out.println("Adherencia:\t\t" + ruedasPista.getAdherencia());
		ruedasPista.setAdherencia(30);
		System.out.println("Nueva adherencia:\t" + ruedasPista.getAdherencia());
		
		System.out.println("\n" + nombres[1]);
		System.out.println("Presion:\t\t" + ruedasRallie.getPresion());
		ruedasRallie.setPresion(7.1f);
		System.out.println("Nueva presion:\t\t" + ruedasRallie.getPresion());
		
		System.out.println("\n" + nombres[2]);
		System.out.println("Diametro de llantas:\t" + ruedasKarts.getLlanta());
		System.out.println("Caducidad:\t\t" + ruedasKarts.getCaducidad());
		ruedasKarts.setCaducidad("30/04/2023");
		System.out.println("Nueva caducidad:\t" + ruedasKarts.getCaducidad());
		
		// Al cambiar el valor de un atributo que proviene de una superclase y que herede la subclase
		// no se cambia el valor de los atributos de otras subclases de la superclase
		System.out.println("\n" + nombres[0]);
		System.out.println("Caducidad:\t\t" + ruedasPista.getCaducidad());
		System.out.println("\n" + nombres[1]);
		System.out.println("Caducidad:\t\t" + ruedasRallie.getCaducidad());
		
	}

}
