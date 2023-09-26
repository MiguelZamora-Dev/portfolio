package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Cita;
import modelo.Cliente;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Vehiculo;

/**
 * @author miguel
 *
 */
public class BorrarDBDAO {
	private Connection con = null;
	
	/**
	 * Constructor para establecer conexion con la base de datos
	 */
	public BorrarDBDAO() {
		try {
			this.con = ConnectionDAO.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Este método borra una cita por id de cita
	 * @param idcita id de la cita
	 * @throws SQLException
	 */
	public void borrarCita (int idcita) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
    			"DELETE * FROM cita WHERE idcita='" + idcita + "'"
    			);
    	ps.executeUpdate();
    	System.out.println("La cita ha sido eliminada de la base de datos");
	}
	
	/**
	 * Este método borra una cita por objeto de tipo Cita
	 * @param ci instancia del objeto Cita 
	 * @throws SQLException
	 */
	public void borrarCita (Cita ci) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
    			"DELETE * FROM cita WHERE idcita='" + ci.getId() + "'"
    			);
    	ps.executeUpdate();
    	System.out.println("La cita ha sido eliminada de la base de datos");
	}
	
	
	/**
	 * Este método borra un cliente por id de cliente
	 * @param idcliente id del cliente
	 * @throws SQLException
	 */
	public void borrarCliente (int idcliente) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"DELETE * FROM cliente WHERE idcliente='" + idcliente + "'"
    			);

    	ps.executeUpdate();
    	System.out.println("El cliente ha sido eliminado de la base de datos");
	}
	
	/**
	 * Este método borra un cliente por objeto de tipo Cliente
	 * @param c instancia de la clase Cliente
	 * @throws SQLException
	 */
	public void borrarCliente (Cliente c) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"DELETE * FROM cliente WHERE idcliente='" + c.getId() + "'"
    			);

    	ps.executeUpdate();
    	System.out.println("El cliente ha sido eliminado de la base de datos");
	}
	
	
	/**
	 * Este método borra un coche por id de coche
	 * @param idcoche id del coche 
	 * @throws SQLException
	 */
	public void borrarCoche (int idcoche) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"DELETE * FROM coche WHERE idcoche='" + idcoche + "'"
    			);
		
    	ps.executeUpdate();
    	System.out.println("El vehiculo ha sido elimando de la base de datos");
	}
	
	/**
	 * Este método borra un coche por objeto del tipo Vehiculo
	 * @param ve instancia del objeto Vehiculo
	 * @throws SQLException
	 */
	public void borrarCoche (Vehiculo ve) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"DELETE * FROM coche WHERE idcoche='" + ve.getId() + "'"
    			);

    	ps.executeUpdate();
    	System.out.println("El vehiculo ha sido eliminado de la base de datos");
	}
	
	
	/**
	 * Este método borra un departamento por id de departamento
	 * @param iddepartamento id del departamento
	 * @throws SQLException
	 */
	public void borrarDepartamento (int iddepartamento) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"DELETE * FROM departamento WHERE iddepartamento='" + iddepartamento + "'"
    			);

    	ps.executeUpdate();
    	System.out.println("El departamento ha sido introducido en la base de datos");
	}
	
	/**
	 * Este método borra un departamento por objeto de tipo Departamento
	 * @param dpt instancia del objeto Departamento
	 * @throws SQLException
	 */
	public void borrarDepartamento (Departamento dpt) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"DELETE * FROM departamento WHERE iddepartamento='" + dpt.getNombre() + "'"
    			);
	
    	ps.executeUpdate();
    	System.out.println("El departamento ha sido eliminado de la base de datos");
	}

	
	/**
	 * Este método borra un empleado por id de empleado
	 * @param idempleado id del empleado
	 * @throws SQLException
	 */
	public void borrarEmpleado (int idempleado) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"DELETE * FROM empleado WHERE idempleado='" + idempleado + "'"
    			);

    	ps.executeUpdate();
    	System.out.println("El empleado ha sido eliminado de la base de datos");
	}
	
	/**
	 * Este método borra un empleado por objeto de tipo Empleado
	 * @param e instancia del objeto Empleado
	 * @throws SQLException
	 */
	public void borrarEmpleado (Empleado e) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"DELETE * FROM empleado WHERE idempleado='" + e.getId() + "'"
    			);
		
    	ps.executeUpdate();
    	System.out.println("El empleado ha sido eliminado de la base de datos");
	}
}
