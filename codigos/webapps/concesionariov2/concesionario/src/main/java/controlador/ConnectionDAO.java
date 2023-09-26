package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDAO {
	
	public static Connection instance = null;
	public static final String cli_JDBC_URL = "jdbc:mysql://localhost:3360/clientes";
	
	/**
	 * Este método establece conexión con la base de datos
	 * @return devuelve la conexion con la base de datos
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		if (instance==null) {
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "BbDdT1M3");
			
			instance = DriverManager.getConnection(cli_JDBC_URL, props);
		}
		return instance;
	}
	
}
