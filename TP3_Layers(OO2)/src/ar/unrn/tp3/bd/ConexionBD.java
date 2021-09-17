package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import ar.unrn.tp3.modelo.Cliente;
import ar.unrn.tp3.modelo.RepositorioClientes;

public class ConexionBD implements RepositorioClientes {

	private Connection dbConn;

	private void setupBaseDeDatos() {
		String url = "jdbc:mysql://localhost:3306/tp3_layers";
		String user = "root";
		String password = "";
		try {
			this.dbConn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException("Error al persistir", e);
		}

	}

	@Override
	public void registrarCliente(Cliente cliente) {
		setupBaseDeDatos();
		PreparedStatement st = null;
		try {
			st = dbConn.prepareStatement("insert into cliente (Nombre, NroTelefono, Region) values(?,?,?)");
			st.setString(1, cliente.getNombre());
			st.setString(2, cliente.getNroTelefono());
			st.setString(3, cliente.getRegion());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeErrorException(new Error(), "Error al persistir");
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				throw new RuntimeException("Error al persistir", e);
			}
		}

	}

}
