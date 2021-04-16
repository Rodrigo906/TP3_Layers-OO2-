package ar.unrn.tp3.modelo;

import javax.management.RuntimeErrorException;

public class NroTelefono {

	private String nroTelefono;

	public NroTelefono(String nroTelefono) {
		if (validarTelefono(String.valueOf(nroTelefono)) && !nroTelefono.equals("")) {
			this.nroTelefono = nroTelefono;
		} else
			throw new RuntimeErrorException(new Error(),
					"El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	public String getValue() {
		return this.nroTelefono;
	}

}
