package modelo;

public final class RuedasKarts extends Ruedas implements IRuedasKart, IRueda {
	/*
	 * Herencia. 
	 * Esta es una subclase de Ruedas y hereda sus métodos y atributos.
	 * Esta clase sí es instanciable y desde ella se inicializan los atributos de la clase paterna
	 * También implementa los métodos declarados en las interfaces señaladas.
	 * En este caso no sería necesaria la utilización de una interfaz para una sola clase de cada tipo
	 * pero si se diese el caso de tener más de un objeto que requiera implementar
	 * los mismos métodos es una buena práctica ya que el desarrollador se vería en la obligación
	 * de implementar dicho método necesario para el correcto funcionamiento. 
	 * Por ejemplo, el método toString es común a todas las clases y un requisito del cliente
	 * por lo que una interfaz facilitaría el proceso de desarrollo
	 */
	
	private int llanta;

	public RuedasKarts (String marca, String caducidad, int dureza, String color, String dibujo, int llanta) {
		super(marca, caducidad, dureza, color, dibujo);
		this.llanta = llanta;
	}
	
	@Override
	public int getLlanta() {
		return this.llanta;
	}

	@Override
	public void setLlanta(int llanta) {
		this.llanta = llanta;
	}

	@Override
	public String toString() {
		String myString = 
				super.toString() + 
				"\nLlanta:\t\t" + this.llanta;
		return myString;
	}
	
}
