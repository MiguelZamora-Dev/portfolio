package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Date;

import modelo.Cita;
import modelo.Cliente;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Vehiculo;

public class IntroducirDBDAO {
	
	private Connection con = null;
	
	/**
	 * Constructor que establece conexion con la base de datos
	 */
	public IntroducirDBDAO() {
		try {
			this.con = ConnectionDAO.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que inserta una nueva Cita en la base de datos por objeto de tipo Cita
	 * @param c objeto de tipo Cita
	 * @throws SQLException
	 */
	public void insertarCita (Cita c) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
    			"INSERT cita (idCliente, fecha) VALUES (?,?)"
    			);
    			
    	ps.setInt(1, c.getCliente().getId());
    	ps.setString(2, c.getFecha());
    	
    	ps.executeUpdate();
    	System.out.println("La cita ha sido introducido en la base de datos");
	}
	
	/**
	 * Método que inserta un nuevo Cliente en la base de datos por objeto de tipo Cliente
	 * @param c objeto de tipo Cliente
	 * @return existe: una variable que indica si ese usuario existe para evitar duplicidades
	 * @throws SQLException
	 */
	public int insertarCliente (Cliente c) throws SQLException {
		int existe = this.existeUsuario(c.getUsuario());
		if (existe == 0) {
			PreparedStatement ps = con.prepareStatement(
	    			"INSERT cliente (nombreCompleto, email, telefono, psw, usuario) VALUES (?,?,?,?,?)"
	    			);
	    	ps.setString(1, c.getNombreCompleto());
	    	ps.setString(2, c.getEmail());
	    	ps.setInt(3, c.getTelefono());
	    	ps.setString(4, c.getPsw());
	    	ps.setString(5, c.getUsuario());
	    	
	    	ps.executeUpdate();
	    	System.out.println("El cliente ha sido introducido en la base de datos");
		} else if (existe == 1) {
			System.out.println("El usuario ya existe");
		}
		return existe;
	}
	
	/**
	 * Método que inserta un nuevo Vehiculo en la base de datos por objeto de tipo Vehiculo
	 * @param ve objeto de tipo Vehiculo
	 * @throws SQLException
	 */
	public void insertarCoche (Vehiculo ve) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
    			"INSERT vehiculo (modelo, matricula, precio, color, caballos, capacidadMaletero, puertas, idcliente) VALUES (?,?,?,?,?,?,?,?)"
    			);
		ps.setString(1, ve.getModelo());
		ps.setString(2, ve.getMatricula());
		ps.setDouble(3, ve.getPrecio());
		ps.setString(4, ve.getColor());
		ps.setInt(5, ve.getCaballos());
    	ps.setInt(6, ve.getCapacidadMaletero());
		ps.setInt(7, ve.getPuertas());
		ps.setInt(8, ve.getComprador().getId());
		
    	ps.executeUpdate();
    	System.out.println("El vehiculo ha sido introducido en la base de datos");
	}
	
	/**
	 * Método que inserta un nuevo Departamento en la base de datos por objeto de tipo Departamento
	 * @param dpt objeto de tipo Departamento
	 * @throws SQLException
	 */
	public void insertarDepartamento (Departamento dpt) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
    			"INSERT departamento (nombreDpt, presupuesto) VALUES (?,?)"
    			);
		ps.setString(1, dpt.getNombre());
		ps.setDouble(2, dpt.getPresupuesto());
		
    	ps.executeUpdate();
    	System.out.println("El departamento ha sido introducido en la base de datos");
	}
	

	/**
	 * Método que inserta un nuevo Empleado en la base de datos por objeto de tipo Empleado
	 * @param e objeto de tipo Empleado
	 * @return existe: variable que indica si ese usuario existe en la base de datos para evitar duplicidades 
	 * @throws SQLException
	 */
	public int insertarEmpleado (Empleado e) throws SQLException {
		int existe = 0;
		PreparedStatement ps = con.prepareStatement(
    			"INSERT empleado (nombreCompleto, sueldo, puesto, departamento, email, telefono, psw, usuario) VALUES (?,?,?,?,?,?,?,?)"
    			);
		ps.setString(1, e.getNombreCompleto());
		ps.setDouble(2, e.getSueldo());
		ps.setString(3, e.getPuesto());
		ps.setString(4, e.getDepartamento().getNombre());
		ps.setString(5, e.getEmail());
    	ps.setInt(6, e.getTelefono());
		ps.setString(7, e.getPsw());
		ps.setString(8, e.getUsuario());
		
    	ps.executeUpdate();
    	System.out.println("El empleado ha sido introducido en la base de datos");
    	return existe;
	}
	
	
	/**
	 * Método auxiliar que indica si existe un usuario en la base de datos
	 * @param usuario string que contiene el nombre de usuario a comprobar
	 * @return existe: variable que indica si existe en la base de datos 
	 * @throws SQLException
	 */
	public int existeUsuario (String usuario) throws SQLException {
		int existe = 0;
		PreparedStatement ps = con.prepareStatement(
    			"SELECT * FROM cliente WHERE usuario='" + usuario + "'");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println("El usuario ya existe");
			existe = 1;
		}
		return existe;
	}
	
	/**
	 * Método que indica si existe un empleado en la base de datos
	 * @param empleado string que contiene el nombre de usuario
	 * @return existe: variable que indica si el empleado figura en la base de datos
	 * @throws SQLException
	 */
	public int existeEmpleado (String empleado) throws SQLException {
		int existe = 0;
		PreparedStatement ps = con.prepareStatement(
    			"SELECT * FROM empleado WHERE usuario='" + empleado + "'");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println("El empleado ya existe");
			existe = 1;
		}
		return existe;
	}
	
	/**
	 * Método que inserta un registro de ataque en la base de datos
	 * Este método añade una nueva entrada de ataque a la base de datos 
	 * @param ataque
	 * @throws SQLException
	 */
	public void insertarAtaque (String ataque) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
    			"INSERT ataque (hora, tipo) VALUES (?,?)"
    			);
		ps.setString(1, new SimpleDateFormat("HH:mm:ss.SSS_dd-MM-yyyy").format(new Date()));
		ps.setString(2, ataque);
		
    	ps.executeUpdate();
    	System.out.println("El ataque ha sido introducido en la base de datos");
	}
}
