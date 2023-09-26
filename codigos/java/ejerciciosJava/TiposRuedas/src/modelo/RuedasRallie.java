package modelo;

public final class RuedasRallie extends Ruedas implements IRuedasRallies, IRueda {
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
	
	private float presion;
	private int profundidadDibujo;
	
	public RuedasRallie (String marca, String caducidad, int dureza, String color, String dibujo, float presion, int profundidadDibujo) {
		super(marca, caducidad, dureza, color, dibujo);
		this.presion = presion;
		this.profundidadDibujo = profundidadDibujo;
	}
	
	@Override
	public float getPresion() {
		return this.presion;
	}
	
	@Override
	public int getProfundidadDibujo() {
		return this.profundidadDibujo;
	}
	
	@Override
	public void setPresion(float presion) {
		this.presion = presion;
	}
	
	@Override
	public void setProfundidadDibujo(int profundidadDibujo) {
		this.profundidadDibujo = profundidadDibujo;
	}

	@Override
	public String toString() {
		String myString = 
				super.toString() + 
				"\nPresion:\t" + this.presion +
				"\nProfund. dibujo: " + this.profundidadDibujo;
		return myString;
	}
	
}