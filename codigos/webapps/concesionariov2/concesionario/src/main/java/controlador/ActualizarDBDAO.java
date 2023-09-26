package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import modelo.Cita;
import modelo.Cliente;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Vehiculo;

public class ActualizarDBDAO {
	
	private Connection con = null;
	
	/**
	 * Constructor para establecer conexion con la base de datos
	 */
	public ActualizarDBDAO() {
		try {
			this.con = ConnectionDAO.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Este método actualiza una cita en la base de datos con los datos recibidos como parámetro
	 * @param ant cita actual
	 * @param nue cita nueva
	 * @throws SQLException
	 * */
	public void actualizarCita (Cita ant, Cita nue) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement(
    			"UPDATE cita SET fecha=" + nue.getId() + " WHERE idcita=" + ant.getId()
    			);

    	
    	ps.executeUpdate();
    	System.out.println("La cita ha sido actualizada en la base de datos");
	}
	
	/**
	 * Este método actualiza un cliente en la base de datos con los datos recibidos como parámetro
	 * @param ant cliente actual
	 * @param nue cliente nuevo
	 * @throws SQLException
	 */
	public void actualizarCliente (Cliente ant, Cliente nue) throws SQLException {

		java.sql.Statement s = con.createStatement();
    	s.addBatch("UPDATE cliente SET nombreCompleto='" + nue.getNombreCompleto() + "' WHERE idcliente=" + ant.getId());
		s.addBatch("UPDATE cliente SET email='" + nue.getEmail() + "' WHERE idcliente=" + ant.getId());
		s.addBatch("UPDATE cliente SET telefono=" + nue.getTelefono() + " WHERE idcliente=" + ant.getId());
		s.addBatch("UPDATE cliente SET psw='" + nue.getPsw() + "' WHERE idcliente=" + ant.getId());
		s.addBatch("UPDATE cliente SET usuario='" + nue.getUsuario() + "' WHERE idcliente=" + ant.getId());
    	
    	s.executeBatch();
    	System.out.println("El cliente ha sido actualizado en la base de datos");
	}
	
	/**
	 * Este método actualiza un coche en la base de datos con los datos recibidos como parámetro
	 * @param ant vehiculo actual
	 * @param nue vehiculo nuevo
	 * @throws SQLException
	 */
	public void actualizarCoche (Vehiculo ant, Vehiculo nue) throws SQLException {
		java.sql.Statement s = con.createStatement();
		
    	s.addBatch("UPDATE vehiculo SET modelo='" + nue.getModelo() + "' WHERE idcoche=" + ant.getId());
    	s.addBatch("UPDATE vehiculo SET matricula='" + nue.getMatricula() + "' WHERE idcoche=" + ant.getId());
    	s.addBatch("UPDATE vehiculo SET precio=" + nue.getPrecio() + " WHERE idcoche=" + ant.getId());
    	s.addBatch("UPDATE vehiculo SET color='" + nue.getColor() + "' WHERE idcoche=" + ant.getId());
    	s.addBatch("UPDATE vehiculo SET caballos=" + nue.getCaballos() + " WHERE idcoche=" + ant.getId());
    	s.addBatch("UPDATE vehiculo SET capacidadMaletero='" + nue.getCapacidadMaletero() + "' WHERE idcoche=" + ant.getId());
    	s.addBatch("UPDATE vehiculo SET puertas=" + nue.getPuertas() + " WHERE idcoche=" + ant.getId());
    	s.addBatch("UPDATE vehiculo SET comprador=" + nue.getComprador().getId() + " WHERE idcoche=" + ant.getId());
		
    	s.executeBatch();
    	System.out.println("El vehiculo ha sido actualizado en la base de datos");
	}
	
	/**
	 * Este método actualiza un departamento en la base de datos con los datos recibidos como parámetro
	 * @param ant departamento actual
	 * @param nue departamento nuevo
	 * @throws SQLException
	 */
	public void actualizarDepartamento (Departamento ant, Departamento nue) throws SQLException {
		java.sql.Statement s = con.createStatement();
		
		s.addBatch("UPDATE departamento SET nombreDpt='" + nue.getNombre() + "' WHERE iddepartamento=" + ant.getIddepartamento());
		s.addBatch("UPDATE departamento SET presupuesto=" + nue.getPresupuesto() + " WHERE iddepartamento=" + ant.getIddepartamento());

    	s.executeBatch();
    	System.out.println("El departamento ha sido actualizado en la base de datos");
	}

	/**
	 * Este método actualiza un empleado en la base de datos con los datos recibidos como parámetro
	 * @param ant empleado actual
	 * @param nue empleado nuevo
	 * @throws SQLException
	 */
	public void actualizarEmpleado (Empleado ant, Empleado nue) throws SQLException {
		java.sql.Statement s = con.createStatement();
		
		s.addBatch("UPDATE empleado SET nombreCompleto='" + nue.getNombreCompleto() + "' WHERE idempleado=" + ant.getId());
		s.addBatch("UPDATE empleado SET sueldo=" + nue.getSueldo() + " WHERE idempleado=" + ant.getId());
		s.addBatch("UPDATE empleado SET puesto='" + nue.getPuesto() + "' WHERE idempleado=" + ant.getId());
		s.addBatch("UPDATE empleado SET departamento='" + nue.getDepartamento().getNombre() + "' WHERE idempleado=" + ant.getId());
		s.addBatch("UPDATE empleado SET email='" + nue.getEmail() + "' WHERE idempleado=" + ant.getId());
		s.addBatch("UPDATE empleado SET telefono=" + nue.getTelefono() + " WHERE idempleado=" + ant.getId());
		s.addBatch("UPDATE empleado SET psw='" + nue.getPsw() + "' WHERE idempleado=" + ant.getId());
		s.addBatch("UPDATE empleado SET usuario='" + nue.getUsuario() + "' WHERE idempleado=" + ant.getId());
		
    	s.executeBatch();
    	System.out.println("El empleado ha sido actualizado en la base de datos");
	}
}
