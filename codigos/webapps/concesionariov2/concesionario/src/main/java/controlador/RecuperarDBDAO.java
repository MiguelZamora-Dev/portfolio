package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Ataque;
import modelo.Cita;
import modelo.Cliente;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Vehiculo;

public class RecuperarDBDAO {
	
	private Connection con = null;
	
	/**
	 * Constructor que establece la conexión con la base de datos
	 */
	public RecuperarDBDAO() {
		try {
			this.con = ConnectionDAO.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Recupera un cliente de la base de datos por id 
	 * @param idcliente id del cliente
	 * @return objeto de tipo Cliente con los datos obtenidos de la base de datos
	 * @throws SQLException
	 */
	public Cliente getClienteFromDB (int idcliente) throws SQLException {
		
    	Cliente cli = new Cliente();
    	System.out.println("Recuperando cliente");
    	PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM cliente WHERE idcliente='" + idcliente + "'"
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
		return cli;
    }
	
	/**
	 * Recupera un cliente de la base de datos por nombre de usuario
	 * @param usuario string que contiene el nombre de usuario
	 * @return objeto de tipo Cliente con los datos obtenidos de la base de datos
	 * @throws SQLException
	 */
	public Cliente getClienteFromDB (String usuario) throws SQLException {
		
    	Cliente cli = new Cliente();
    	System.out.println("Recuperando cliente");
    	PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM cliente WHERE usuario='" + usuario + "'"
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
		return cli;
    }
	
	/**
	 * Recupera un cliente de la base de datos por nombre de usuario y contraseña (En siguente versión: Deprecated)
	 * @param usuario string que contiene el nombre de usuario
	 * @param password string que contiene la contraseña del usuario
	 * @return objeto de tipo Cliente con los datos obtenidos de la base de datos
	 * @throws SQLException
	 */
	public Cliente getClienteFromDB (String usuario, String password) throws SQLException {
    	Cliente cli = new Cliente();
    	System.out.println("Recuperando cliente");
    	PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM cliente WHERE usuario='" + usuario + "' AND psw='" + password + "'"
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
		return cli;
    }
    
	/**
	 * Método que recupera un empleado de la base de datos por nombre de usuario
	 * @param usuario string que contiene el nombre usuario
	 * @return objeto de tipo Empleado con los datos obtenidos de la base de datos
	 * @throws SQLException
	 */
	public Empleado getEmpleadoFromDB (String usuario) throws SQLException {
    	Empleado emp = new Empleado();
    	System.out.println("Recuperando empleado");
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM empleado WHERE usuario='" + usuario + "'"
				);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			emp.setId(rs.getInt("idempleado"));
			emp.setNombreCompleto(rs.getString("nombreCompleto"));
			emp.setEmail(rs.getString("email"));
			emp.setTelefono(rs.getInt("telefono"));
			emp.setPsw(rs.getString("psw"));
			emp.setUsuario(rs.getString("usuario"));
			emp.setTelefono(rs.getInt("sueldo"));
			emp.setPsw(rs.getString("puesto"));
			emp.setDepartamento(rs.getString("departamento"));
			System.out.println("El empleado " + emp.getUsuario() + " ha iniciado sesion");
		}
		return emp;
    }
	
	/**
	 * Recupera un empleado de la base de datos por nombre de usuario y contraseña (En siguente versión: Deprecated)
	 * @param usuario string que contiene el nombre de usuario
	 * @param password string que contiene la contraseña del usuario
	 * @return objeto de tipo Empleado con los datos obtenidos de la base de datos
	 * @throws SQLException
	 */
    public Empleado getEmpleadoFromDB (String usuario, String password) throws SQLException {
    	Empleado emp = new Empleado();
    	System.out.println("Recuperando empleado");
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM empleado WHERE usuario='" + usuario + "' AND psw='" + password + "'"
				);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			emp.setId(rs.getInt("idempleado"));
			emp.setNombreCompleto(rs.getString("nombreCompleto"));
			emp.setEmail(rs.getString("email"));
			emp.setTelefono(rs.getInt("telefono"));
			emp.setPsw(rs.getString("psw"));
			emp.setUsuario(rs.getString("usuario"));
			emp.setTelefono(rs.getInt("sueldo"));
			emp.setPsw(rs.getString("puesto"));
			emp.setDepartamento(rs.getString("departamento"));
			System.out.println("El empleado " + emp.getUsuario() + " ha iniciado sesion");
		}
		return emp;
    }
    
    /**
     * Método que recupera un vehiculo de la base de datos por id 
     * @param idcoche id del vehículo
     * @return objeto de tipo Vehiculo con los datos obtenidos de la base de datos
     * @throws SQLException
     */
    public Vehiculo getVehiculoFromDB (int idcoche) throws SQLException {
    	Vehiculo ve = new Vehiculo();
    	System.out.println("Recuperando vehiculo");
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM coche WHERE idcoche='" + idcoche + "'"
				);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			ve.setId(rs.getInt("idcoche"));
			ve.setModelo(rs.getString("modelo"));
			ve.setMatricula(rs.getString("matricula"));
			ve.setPrecio(rs.getDouble("precio"));
			ve.setColor(rs.getString("color"));
			ve.setCaballos(rs.getInt("caballos"));
			ve.setCapacidadMaletero(rs.getInt("capacidadMaletero"));
			ve.setPuertas(rs.getInt("puertas"));
			ve.setComprador(rs.getInt("idcliente"));
			System.out.println("El modelo " + ve.getModelo() + " ha sido recuperado de la base de datos");
		}
		return ve;
    }
    
    /**
     * Método que recupera un vehiculo de la base de datos por nombre del modelo
     * @param modelo nombre del modelo
     * @return objeto de tipo Vehiculo con los datos obtenidos de la base de datos
     * @throws SQLException
     */
    public Vehiculo getVehiculoFromDBByModelo (String modelo) throws SQLException {
    	Vehiculo ve = new Vehiculo();
    	System.out.println("Recuperando vehiculo");
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM coche WHERE modelo='" + modelo + "'"
				);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			ve.setId(rs.getInt("idcoche"));
			ve.setModelo(rs.getString("modelo"));
			ve.setMatricula(rs.getString("matricula"));
			ve.setPrecio(rs.getDouble("precio"));
			ve.setColor(rs.getString("color"));
			ve.setCaballos(rs.getInt("caballos"));
			ve.setCapacidadMaletero(rs.getInt("capacidadMaletero"));
			ve.setPuertas(rs.getInt("puertas"));
			ve.setComprador(rs.getInt("idcliente"));
			System.out.println("El modelo " + ve.getModelo() + " ha sido recuperado de la base de datos");
		}
		return ve;
    }
    
    /**
     * Método que recupera un vehiculo de la base de datos por id del cliente
     * @param idcliente id del cliente
     * @return objeto de tipo Vehiculo con los datos obtenidos de la base de datos
     * @throws SQLException
     */
    public Vehiculo getVehiculoFromDBByCli (int idcliente) throws SQLException {
    	Vehiculo ve = new Vehiculo();
    	System.out.println("Recuperando vehiculo");
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM coche WHERE idcliente='" + idcliente + "'"
				);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			ve.setId(rs.getInt("idcoche"));
			ve.setModelo(rs.getString("modelo"));
			ve.setMatricula(rs.getString("matricula"));
			ve.setPrecio(rs.getDouble("precio"));
			ve.setColor(rs.getString("color"));
			ve.setCaballos(rs.getInt("caballos"));
			ve.setCapacidadMaletero(rs.getInt("capacidadMaletero"));
			ve.setPuertas(rs.getInt("puertas"));
			ve.setComprador(rs.getInt("idcliente"));
			System.out.println("El modelo " + ve.getModelo() + " ha sido recuperado de la base de datos");
		}
		return ve;
    }
    
    /**
     * Método que recupera una cita de la base de datos por id de la cita
     * @param idcita id de la cita
     * @return objeto de tipo Cita con los datos obtenidos de la base de datos
     * @throws SQLException
     */
    public Cita getCitaFromDB (int idcita) throws SQLException {
    	Cita ci = new Cita();
    	System.out.println("Recuperando cita");
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM cita WHERE idcita='" + idcita + "'"
				);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			ci.setId(rs.getInt("idcita"));
			ci.setCliente(rs.getInt("idCliente"));
			ci.setFecha(rs.getString("fecha"));
			System.out.println("El cliente " + ci.getCliente() + " tiene una cita el " + ci.getFecha());
		}
		return ci;
    }
    
    /**
     * Método que recupera una cita de la base de datos por id del cliente
     * @param idCliente id del cliente
     * @return objeto de tipo Cita con los datos obtenidos de la base de datos
     * @throws SQLException
     */
    public Cita getCitaFromDBByCli (int idCliente) throws SQLException {
    	Cita ci = new Cita();
    	System.out.println("Recuperando cita");
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM cita WHERE idCliente='" + idCliente + "'"
				);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			ci.setId(rs.getInt("idcita"));
			ci.setCliente(rs.getInt("idCliente"));
			ci.setFecha(rs.getString("fecha"));
			System.out.println("El cliente " + ci.getCliente() + " tiene una cita el " + ci.getFecha());
		}
		return ci;
    }
    
    /**
     * Método que recupera un departamento de la base de datos por el nombre del departamento
     * @param departamento string que contiene el nombre del departamento
     * @return objeto de tipo Departamento con los datos obtenidos de la base de datos
     * @throws SQLException
     */
    public Departamento getDepartamentoFromDB (String departamento) throws SQLException {
    	Departamento dpt = new Departamento();
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM departamento WHERE nombreDpt='" + departamento + "'" 
				);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			dpt.setNombre(rs.getString("nombreDpt"));
			dpt.setPresupuesto(rs.getDouble("presupuesto"));
		}
		return dpt;
    }
    
    /**
     * Método que recupera de la base de datos el listado de ataques al sitio
     * @return ArrayList de ataques
     * @throws SQLException
     */
    public ArrayList<Ataque> getAtaquesFromDB () throws SQLException {
    	ArrayList<Ataque> ataques = new ArrayList<Ataque>();
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM ataque" 
				);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ataques.add(new Ataque(rs.getString(2), rs.getString(3)));
		}
		return ataques;
    }
	
}
