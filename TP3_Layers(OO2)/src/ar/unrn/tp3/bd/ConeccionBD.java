package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConeccionBD {

	private Connection dbConn;

	private void setupBaseDeDatos() throws SQLException {
		String url = "jdbc:derby://localhost:1527/participantes";
		String user = "app";
		String password = "app";
		this.dbConn = DriverManager.getConnection(url, user, password);
	}
}
