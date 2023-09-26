package modelo;

public final class RuedasPista extends Ruedas implements IRuedasPista, IRueda{
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
	
	private int adherencia;
	private float temperatura;

	public RuedasPista (String marca, String caducidad, int dureza, String color, String dibujo, int adherencia, float temperatura) {
		super(marca, caducidad, dureza, color, dibujo);
		this.adherencia = adherencia;
		this.temperatura = temperatura;
	}
	
	@Override
	public int getAdherencia() {
		return this.adherencia;
	}

	@Override
	public float getTemperatura() {
		return this.temperatura;
	}

	@Override
	public void setAdherencia(int adherencia) {
		this.adherencia = adherencia;
	}

	@Override
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		String myString = 
				super.toString() + 
				"\nAdherencia:\t" + this.adherencia +
				"\nTemperatura:\t" + this.temperatura;
		return myString;
	}
}