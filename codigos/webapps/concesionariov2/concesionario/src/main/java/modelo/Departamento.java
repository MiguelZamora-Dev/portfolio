package modelo;


public final class Departamento {
	private int iddepartamento;
	private String nombre;
	private double presupuesto;
	
	/**
	 * Constructor de la clase
	 */
	public Departamento() {
		super();
	}

	/**
	 * Constructor de la clase
	 */
	public Departamento(String nombre, double presupuesto) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}
	
	/**
	 * Constructor de la clase
	 */
	public Departamento(int iddepartamento, String nombre, double presupuesto) {
		this.iddepartamento = iddepartamento;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}
	
	public int getIddepartamento() {
		return this.iddepartamento;
	}

	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
}
