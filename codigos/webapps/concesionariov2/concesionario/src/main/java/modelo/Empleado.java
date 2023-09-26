package modelo;

import java.sql.SQLException;

import controlador.ActualizarDBDAO;
import controlador.RecuperarDBDAO;

public final class Empleado extends Persona{
	private double sueldo;
	private String puesto;
	private Departamento departamento;
	private RecuperarDBDAO rdao;
	private ActualizarDBDAO udao;
	
	/**
	 * Constructor de la clase
	 */
	public Empleado (){
        this.rdao = new RecuperarDBDAO();
        this.udao = new ActualizarDBDAO();
	}
	
	/**
	 * Constructor de la clase
	 */
	public Empleado (String nombreCompleto, String email, int telefono, String psw, 
			String usuario, double sueldo, String puesto, Departamento departamento) {
		super(nombreCompleto, email, telefono, psw, usuario);
		this.sueldo = sueldo;
		this.puesto = puesto;
		this.departamento = departamento;
        this.rdao = new RecuperarDBDAO();
        this.udao = new ActualizarDBDAO();
	}
	
	/**
	 * Constructor de la clase
	 */
	public Empleado (int id, String nombreCompleto, String email, int telefono, String psw, 
			String usuario, double sueldo, String puesto, Departamento departamento) {
		super(id, nombreCompleto, email, telefono, psw, usuario);
		this.sueldo = sueldo;
		this.puesto = puesto;
		this.departamento = departamento;
        this.rdao = new RecuperarDBDAO();
        this.udao = new ActualizarDBDAO();
	}

	public double getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public void setDepartamento(String departamento) throws SQLException {
		this.departamento = this.rdao.getDepartamentoFromDB(departamento);
	}
	
}
