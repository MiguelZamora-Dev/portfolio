package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.ConnectionDAO;

public class Vehiculo {
	private int id;
	private String modelo;
	private String matricula;
	private double precio;
	private String color;
	private int caballos;
	private int capacidadMaletero;
	private int puertas;
	private ArrayList<String> colores;
	private Cliente comprador;
	private Connection con = null;
	
	/**
	 * Constructor de la clase
	 */
	public Vehiculo() {
		try {
			this.con = ConnectionDAO.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructor de la clase
	 */
	public Vehiculo(String modelo, String matricula, double precio, String color, int caballos, int capacidadMaletero,
			int puertas, Cliente comprador) {
		this.modelo = modelo;
		this.matricula = matricula;
		this.precio = precio;
		this.color = color;
		this.caballos = caballos;
		this.capacidadMaletero = capacidadMaletero;
		this.puertas = puertas;
		this.comprador = comprador;
		try {
			this.con = ConnectionDAO.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Constructor de la clase
	 */
	public Vehiculo(String modelo, String matricula, double precio, ArrayList<String> colores, int caballos, int capacidadMaletero,
			int puertas) {
		this.modelo = modelo;
		this.matricula = matricula;
		this.precio = precio;
		this.colores = colores;
		this.caballos = caballos;
		this.capacidadMaletero = capacidadMaletero;
		this.puertas = puertas;
		try {
			this.con = ConnectionDAO.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Constructor de la clase
	 */
	public Vehiculo(int id, String modelo, String matricula, double precio, String color, int caballos, int capacidadMaletero,
			int puertas, Cliente comprador) {
		this.id = id;
		this.modelo = modelo;
		this.matricula = matricula;
		this.precio = precio;
		this.color = color;
		this.caballos = caballos;
		this.capacidadMaletero = capacidadMaletero;
		this.puertas = puertas;
		this.comprador = comprador;
		try {
			this.con = ConnectionDAO.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public ArrayList<String> getColores() {
		return this.colores;
	}

	public void setColores(ArrayList<String> colores) {
		this.colores = colores;
	}

	public int getCaballos() {
		return this.caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public int getCapacidadMaletero() {
		return this.capacidadMaletero;
	}

	public void setCapacidadMaletero(int capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

	public int getPuertas() {
		return this.puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public Cliente getComprador() {
		return this.comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}
	
	public void setComprador(int comprador) {
		Cliente cli = new Cliente();
    	System.out.println("Recuperando cliente");
    	PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"SELECT * FROM cliente WHERE idcliente='" + comprador + "'"
					);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cli.setId(rs.getInt("idcliente"));
				cli.setNombreCompleto(rs.getString("nombreCompleto"));
				cli.setEmail(rs.getString("email"));
				cli.setTelefono(rs.getInt("telefono"));
				cli.setPsw(rs.getString("psw"));
				cli.setUsuario(rs.getString("usuario"));
				System.out.println("El cliente " + cli.getNombreCompleto() + " ha iniciado sesion");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.comprador = cli;
	}
	
}
