package modelo;

public abstract class Persona {
	private int id;
	private String nombreCompleto;
	private String email;
	private int telefono;
	private String psw;
	private String usuario;
	
	/**
	 * Constructor de la clase
	 */
	public Persona () {
		
	}
	
	/**
	 * Constructor de la clase
	 */
	public Persona(String nombreCompleto, String email, int telefono, String psw, String usuario) {
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.telefono = telefono;
		this.psw = psw;
		this.usuario = usuario;
	}
	
	/**
	 * Constructor de la clase
	 */
	public Persona(int id, String nombreCompleto, String email, int telefono, String psw, String usuario) {
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.telefono = telefono;
		this.psw = psw;
		this.usuario = usuario;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getPsw() {
		return this.psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
