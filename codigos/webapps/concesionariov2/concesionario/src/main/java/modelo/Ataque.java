package modelo;

public class Ataque {
	private String hora;
	private String tipo;
	
	public Ataque() {
		super();
	}
	
	public Ataque(String hora, String tipo) {
		super();
		this.hora = hora;
		this.tipo = tipo;
	}

	public String getHora() {
		return this.hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
