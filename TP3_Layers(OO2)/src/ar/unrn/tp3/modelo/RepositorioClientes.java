package ar.unrn.tp3.modelo;

import java.sql.SQLException;

public interface RepositorioClientes {

	void registrarCliente(Cliente cliente) throws SQLException;

}
