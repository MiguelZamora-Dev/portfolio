
import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		
		Fiesta fiesta = new Fiesta();

		System.out.println("[consulta]\t" + fiesta.consulta());
		System.out.println("[toString]\t" + fiesta.toString());
		fiesta.invitar();
		fiesta.invitar();
		fiesta.setBebidas(6);
		fiesta.setBocadillos(6);
		System.out.println("[mod 1]\t\t" + fiesta.toString());
		fiesta.cancelarInvitacion();
		System.out.println("[mod 2]\t\t" + fiesta.toString());
		System.out.println();		
		System.out.println("Bebidas:\t" + fiesta.getBebidas());
		System.out.println("Bocadillos:\t" + fiesta.getBocadillos());
		System.out.println("Direccion:\t" + fiesta.getDireccion());
		System.out.println("Num. invitados:\t" + fiesta.getInvitados());
		System.out.println("Fecha y hora:\t" + fiesta.getFechaHora());
		System.out.println("Tipo de fiesta:\t" + fiesta.getTipo());
		System.out.println("El precio de la fiesta sera de " + fiesta.precioFiesta() + " euros");
		
		System.out.println("_____________________________________________________________________________");
		
		Fiesta fiesta1 = new Fiesta();
		
		fiesta1.setBebidas(15);
		fiesta1.setBocadillos(15);
		fiesta1.setDireccion("C/ EstoEsUnaCalle, num, pisoYLetra");
		fiesta1.setFechaHora(LocalDateTime.of(2022, 05, 24, 18, 00));
		fiesta1.setInvitados(5);
		fiesta1.setTipo("reunion de amigos");
		
		System.out.println();		
		System.out.println("Bebidas:\t" + fiesta1.getBebidas());
		System.out.println("Bocadillos:\t" + fiesta1.getBocadillos());
		System.out.println("Direccion:\t" + fiesta1.getDireccion());
		System.out.println("Num. invitados:\t" + fiesta1.getInvitados());
		System.out.println("Fecha y hora:\t" + fiesta1.getFechaHora());
		System.out.println("Tipo de fiesta:\t" + fiesta1.getTipo());
		System.out.println("El precio de la fiesta sera de " + fiesta1.precioFiesta() + " euros");
		
		System.out.println("_____________________________________________________________________________");
		
		Fiesta fiesta2 = new Fiesta(
				"disfraces", 
				LocalDateTime.of(2022, 05, 24, 18, 00), 
				"mi casa", 
				5, 
				5);

		System.out.println();		
		System.out.println("Bebidas:\t" + fiesta2.getBebidas());
		System.out.println("Bocadillos:\t" + fiesta2.getBocadillos());
		System.out.println("Direccion:\t" + fiesta2.getDireccion());
		System.out.println("Num. invitados:\t" + fiesta2.getInvitados());
		System.out.println("Fecha y hora:\t" + fiesta2.getFechaHora());
		System.out.println("Tipo de fiesta:\t" + fiesta2.getTipo());

		fiesta2.setInvitados(5);
		System.out.println(fiesta2.toString());
		System.out.println("El precio de la fiesta sera de " + fiesta2.precioFiesta() + " euros");
	}

}
