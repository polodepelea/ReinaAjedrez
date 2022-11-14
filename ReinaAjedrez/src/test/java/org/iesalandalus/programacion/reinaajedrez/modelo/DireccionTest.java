package org.iesalandalus.programacion.reinaajedrez.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class DireccionTest {
	
	private static final String NOMBRE_NO_VALIDO = "El nombre de la dirección no es válido.";

	@Test
	void nombresValidosDirecciones() {
		assertEquals("NORTE", Direccion.NORTE.toString(), NOMBRE_NO_VALIDO);
		assertEquals("NORESTE", Direccion.NORESTE.toString(), NOMBRE_NO_VALIDO);
		assertEquals("ESTE", Direccion.ESTE.toString(), NOMBRE_NO_VALIDO);
		assertEquals("SURESTE", Direccion.SURESTE.toString(), NOMBRE_NO_VALIDO);
		assertEquals("SUR", Direccion.SUR.toString(), NOMBRE_NO_VALIDO);
		assertEquals("SUROESTE", Direccion.SUROESTE.toString(), NOMBRE_NO_VALIDO);
		assertEquals("OESTE", Direccion.OESTE.toString(), NOMBRE_NO_VALIDO);
		assertEquals("NOROESTE", Direccion.NOROESTE.toString(), NOMBRE_NO_VALIDO);
	}

}
