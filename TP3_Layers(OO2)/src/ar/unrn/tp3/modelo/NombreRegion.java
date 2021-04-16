package ar.unrn.tp3.modelo;

import javax.management.RuntimeErrorException;

public class NombreRegion {

	private String nombreRegion;

	public NombreRegion(String nombreRegion) {
		if (!nombreRegion.equals("China") && !nombreRegion.equals("US") && !nombreRegion.equals("Europa")) {
			throw new RuntimeErrorException(new Error(), "Region desconocida. Las conocidas son: China, US, Europa");
		}
		this.nombreRegion = nombreRegion;
	}

	public String getValue() {
		return this.nombreRegion;
	}

}
