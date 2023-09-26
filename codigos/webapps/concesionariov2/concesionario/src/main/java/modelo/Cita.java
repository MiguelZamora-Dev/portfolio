package modelo;

import java.sql.SQLException;
import java.time.LocalDateTime;

import controlador.RecuperarDBDAO;

public final class Cita {
	private int id;
	private Cliente cliente;
	private String fecha;
		
	/**
	 * Constructor de la clase
	 */
	public Cita() {
		super();
	}

	/**
	 * Constructor de la clase
	 */
	public Cita(Cliente cliente, String fecha) {
		this.cliente = cliente;
		this.fecha = fecha;
	}
	
	/**
	 * Constructor de la clase
	 */
	public Cita(int id, Cliente cliente, String fecha) {
		this.id = id;
		this.cliente = cliente;
		this.fecha = fecha;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setCliente(int idcliente) {
		RecuperarDBDAO recCli = new RecuperarDBDAO();
		try {
			this.cliente = recCli.getClienteFromDB(idcliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
