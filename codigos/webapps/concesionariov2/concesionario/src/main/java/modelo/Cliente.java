package modelo;

public final class Cliente extends Persona{
	
	/**
	 * Constructor de la clase Cliente
	 */
	public Cliente () {
		
	}
	
	/**
	 * Constructor de la clase Cliente
	 */
	public Cliente(String nombreCompleto, String email, int telefono, String psw, String usuario) {
		super(nombreCompleto, email, telefono, psw, usuario);
	}
	
	/**
	 * Constructor de la clase Cliente
	 */
	public Cliente(int id, String nombreCompleto, String email, int telefono, String psw, String usuario) {
		super(id, nombreCompleto, email, telefono, psw, usuario);
	}

}
