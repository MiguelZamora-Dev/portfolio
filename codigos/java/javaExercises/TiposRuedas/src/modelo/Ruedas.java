package modelo;

public abstract class Ruedas implements IRueda{
	/*
	 * Clase abstracta que será el objeto paterno de tres subclases:
	 * RuedasPista, RuedasRallie y RuedasKarts
	 */
	
	// Atributos
	private String marca;
	private String caducidad;
	private int dureza;
	private String color;
	private String dibujo;
	
	// Constructor
	public Ruedas(String marca, String caducidad, int dureza, String color, String dibujo) {
		this.marca = marca;
		this.caducidad = caducidad;
		this.dureza = dureza;
		this.color = color; 
		this.dibujo = dibujo;
	}
	
	// getters
	public String getMarca() {
		return this.marca;
	}

	public String getCaducidad() {
		return this.caducidad;
	}

	public int getDureza() {
		return this.dureza;
	}

	public String getColor() {
		return this.color;
	}

	public String getDibujo() {
		return this.dibujo;
	}

	// setters
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}

	public void setDureza(int dureza) {
		this.dureza = dureza;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setDibujo(String dibujo) {
		this.dibujo = dibujo;
	}
	
	// Métodos
	public String checkDureza () {
		String _dureza;
		
		if ( this.dureza < 10 ) {
			_dureza = "Neumatico blando";
		} 
		else if ( 10 <= this.dureza && this.dureza <= 50 ) {
			_dureza = "Neumatico de dureza media";
		}
		else {
			_dureza = "Neumatico duro";
		}
		
		return _dureza;
	}
	
	public String marcaCaducidad () {
		return "  Marca: " + this.marca + ". Caducidad: " + this.caducidad ;
	}
	
	@Override
	public String toString() {
		String myString = 
				"Marca:\t\t" + this.marca + 
				"\nCaducidad:\t" + this.caducidad +
				"\nDureza:\t\t" + this.dureza +
				"\nColor:\t\t" + this.color +
				"\nDibujo:\t\t" + this.dibujo;
		return myString;
	}
}






