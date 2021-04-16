package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp3.modelo.Cliente;
import ar.unrn.tp3.modelo.RepositorioClientes;

public class ConexionBD implements RepositorioClientes {

	private Connection dbConn;

	private void setupBaseDeDatos() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/tp3_layers";
		String user = "root";
		String password = "";
		this.dbConn = DriverManager.getConnection(url, user, password);

	}

	@Override
	public void registrarCliente(Cliente cliente) throws SQLException {
		setupBaseDeDatos();
		PreparedStatement st = dbConn
				.prepareStatement("insert into cliente (Nombre, NroTelefono, Region) values(?,?,?)");
		try {
			st.setString(1, cliente.getNombre());
			st.setString(2, cliente.getNroTelefono());
			st.setString(3, cliente.getRegion());
			st.executeUpdate();
		} finally {
			st.close();
		}

	}

}
