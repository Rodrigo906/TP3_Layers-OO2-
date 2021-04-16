package ar.unrn.tp3.modelo;

import javax.management.RuntimeErrorException;

public class Cliente {

	private String nombre;
	private NroTelefono nroTelefono;
	private NombreRegion region;

	public Cliente(String nombre, String nroTelefono, String region) {

		if (nombre.equals("")) {
			throw new RuntimeErrorException(new Error(), "Debe cargar un nombre");
		}

		this.nombre = nombre;
		this.nroTelefono = new NroTelefono(nroTelefono);
		this.region = new NombreRegion(region);
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getNroTelefono() {
		return this.nroTelefono.getValue();
	}

	public String getRegion() {
		return this.region.getValue();
	}

}
