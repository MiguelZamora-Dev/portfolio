package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;

public class ClienteDAO {
	
	private Connection con = null;
	
	public ClienteDAO() {
		try {
			this.con = ConnectionDAO.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
}
