package controlador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import modelo.Cliente;

class controladorTest {

	@Test
	void testInsertarCliente() {
		Cliente cliente = new Cliente("Miguel Zamora", "correo@gmail.com", 123456789, "a", "miguel98");
		assert(cliente.getUsuario()!=null);
		IntroducirDBDAO c = new IntroducirDBDAO();
		
		try {
			assert(c.existeUsuario(cliente.getUsuario())!=1);
			Connection con = ConnectionDAO.getConnection();
			assert (con!=null);
			PreparedStatement ps = con.prepareStatement(
					"INSERT cliente (nombreCompleto, email, telefono, psw, usuario) VALUES (?,?,?,?,?)"
				);
			assert (!ps.isClosed());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Test
	void testInsertarAtaque() {
		
		
		try {
			Connection con = ConnectionDAO.getConnection();
			assert (con!=null);
			PreparedStatement ps = con.prepareStatement(
					"INSERT ataque (hora, tipo) VALUES (?,?)"
				);
			assert (!ps.isClosed());

		} catch (SQLException e) {
			e.printStackTrace();
		}


		
	}

}
