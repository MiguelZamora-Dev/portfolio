package modelo;

public final class CustomRuedasPista extends Ruedas implements IRueda, IRuedasPista{

	private String nombre;
	private int adherencia;
	private float temperatura;
	
	public CustomRuedasPista(String marca, String caducidad, int dureza, String color, String dibujo, int adherencia, float temperatura, String nombre) {
		super(marca, caducidad, dureza, color, dibujo);
		// TODO Auto-generated constructor stub
		this.adherencia = adherencia;
		this.temperatura = temperatura;
		this.nombre = nombre;
	}

	// Implementaciones de los métodos declarados en la interfaz IRuedasPista
	@Override
	public int getAdherencia() {
		// TODO Auto-generated method stub
		return this.adherencia;
	}

	@Override
	public float getTemperatura() {
		// TODO Auto-generated method stub
		return this.temperatura;
	}

	@Override
	public void setAdherencia(int adherencia) {
		// TODO Auto-generated method stub
		this.adherencia = adherencia;
	}

	@Override
	public void setTemperatura(float temperatura) {
		// TODO Auto-generated method stub
		this.temperatura = temperatura;
	}
	
	
	// Implementaciones de los getters y setters pertenecientes únicamente a esta clase
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
