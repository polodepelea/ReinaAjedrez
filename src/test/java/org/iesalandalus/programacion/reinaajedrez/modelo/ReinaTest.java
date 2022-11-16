package org.iesalandalus.programacion.reinaajedrez.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.naming.OperationNotSupportedException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReinaTest {

	private static final String COLOR_NO_ESPERADO = "El color no es el esperado.";
	private static final String POSICION_NO_ESPERADA = "La posición no es la esperada.";
	private static final String CADENA_NO_ESPERADA = "La cadena devuelta no es la esperada.";
	private static final String EXCEPCION_NO_VALIDA = "El tipo de excepción no es válido o no ha saltado.";
	private static final String MENSAJE_ERROR_COLOR_NULO = "ERROR: El color no puede ser nulo.";
	private static final String MENSAJE_ERROR_DIRECCION_NULA = "ERROR: La dirección no puede ser nula.";
	private static final String MENSAJE_ERROR_PASOS_NO_VALIDOS = "ERROR: El número de pasos debe estar comprendido entre 1 y 7.";
	private static final String MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO = "ERROR: Movimiento no válido (se sale del tablero).";
	private static final String MENSAJE_NO_CORRECTO = "El mensaje devuelto por la excepción no es correcto.";
	
	private static Posicion posicionDefectoNegra;
	private static Posicion posicionDefectoBlanca;
	private static Reina reinaBlanca;
	private static Reina reinaNegra;
	
	@BeforeAll
	static void asignarValoresPosiciones() {
		posicionDefectoNegra = new Posicion(8, 'd');
		posicionDefectoBlanca = new Posicion(1, 'd');
	}
	
	@BeforeEach
	void asignarValoresReinas() {
		reinaBlanca = new Reina(Color.BLANCO);
		reinaNegra = new Reina(Color.NEGRO);
	}
	
	@Test
	void constructorDefectoCreaReinaBlancaEnPosicion1d() {
		Reina reinaDefecto = new Reina();
		assertEquals(Color.BLANCO, reinaDefecto.getColor(), COLOR_NO_ESPERADO);
		assertEquals(posicionDefectoBlanca, reinaDefecto.getPosicion(), POSICION_NO_ESPERADA);
	}
	
	@Test
	void constructorColorCorrectoCreaReinaColorPosicionAdecuados() {
		assertEquals(Color.BLANCO, reinaBlanca.getColor(), COLOR_NO_ESPERADO);
		assertEquals(posicionDefectoBlanca, reinaBlanca.getPosicion(), POSICION_NO_ESPERADA);
		assertEquals(Color.NEGRO, reinaNegra.getColor(), COLOR_NO_ESPERADO);
		assertEquals(posicionDefectoNegra, reinaNegra.getPosicion(), POSICION_NO_ESPERADA);
	}
	
	@Test
	void constructorColorNuloLanzaExcepcion() {
		NullPointerException excepcion = assertThrows(NullPointerException.class, () -> { new Reina(null);}, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_COLOR_NULO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
	}
	
	@Test
	void moverDireccionNulaPasosIndiferenteLanzaExcepcion() {
		NullPointerException excepcion = assertThrows(NullPointerException.class, () -> { reinaBlanca.mover(null, 0);}, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_DIRECCION_NULA, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(NullPointerException.class, () -> { reinaBlanca.mover(null, 1);}, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_DIRECCION_NULA, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(NullPointerException.class, () -> { reinaBlanca.mover(null, 8);}, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_DIRECCION_NULA, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
	}
	
	@Test
	void moverDireccionValidaPasosNoValidos() {
		IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> { reinaBlanca.mover(Direccion.NORTE, 0);}, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_PASOS_NO_VALIDOS, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(IllegalArgumentException.class, () -> { reinaBlanca.mover(Direccion.NORTE, 8);}, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_PASOS_NO_VALIDOS, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
	}
	
	@Test
	void moverDireccionValidaPasosValidosSeSaleTableroLanzaExcepcion() {
		OperationNotSupportedException excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaBlanca.mover(Direccion.ESTE, 5); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaBlanca.mover(Direccion.NORESTE, 5); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaBlanca.mover(Direccion.NOROESTE, 5); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaBlanca.mover(Direccion.ESTE, 5); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaBlanca.mover(Direccion.OESTE, 4); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaBlanca.mover(Direccion.SUROESTE, 1); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaBlanca.mover(Direccion.SUR, 1); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaBlanca.mover(Direccion.SUROESTE, 1); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaNegra.mover(Direccion.NORTE, 1); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaNegra.mover(Direccion.NORESTE, 1); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaNegra.mover(Direccion.ESTE, 5); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaNegra.mover(Direccion.SURESTE, 5); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaNegra.mover(Direccion.SUROESTE, 4); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaNegra.mover(Direccion.OESTE, 4); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
		excepcion = assertThrows(OperationNotSupportedException.class, () -> { reinaNegra.mover(Direccion.NOROESTE, 1); }, EXCEPCION_NO_VALIDA);
		assertEquals(MENSAJE_ERROR_MOVIMIENTO_NO_VALIDO, excepcion.getMessage(), MENSAJE_NO_CORRECTO);
	}
	
	@Test
	void moverDireccionValidaPassosValidosMueveCorrectamente() throws OperationNotSupportedException {
		reinaBlanca.mover(Direccion.NORTE, 1);
		assertEquals(new Posicion(2, 'd'), reinaBlanca.getPosicion(), POSICION_NO_ESPERADA);
		reinaBlanca.mover(Direccion.NORESTE, 1);
		assertEquals(new Posicion(3, 'e'), reinaBlanca.getPosicion(), POSICION_NO_ESPERADA);
		reinaBlanca.mover(Direccion.ESTE, 1);
		assertEquals(new Posicion(3, 'f'), reinaBlanca.getPosicion(), POSICION_NO_ESPERADA);
		reinaBlanca.mover(Direccion.SURESTE, 1);
		assertEquals(new Posicion(2, 'g'), reinaBlanca.getPosicion(), POSICION_NO_ESPERADA);
		reinaBlanca.mover(Direccion.SUR, 1);
		assertEquals(new Posicion(1, 'g'), reinaBlanca.getPosicion(), POSICION_NO_ESPERADA);
		reinaNegra.mover(Direccion.SUR, 1);
		assertEquals(new Posicion(7, 'd'), reinaNegra.getPosicion(), POSICION_NO_ESPERADA);
		reinaNegra.mover(Direccion.SUROESTE, 1);
		assertEquals(new Posicion(6, 'c'), reinaNegra.getPosicion(), POSICION_NO_ESPERADA);
		reinaNegra.mover(Direccion.OESTE, 1);
		assertEquals(new Posicion(6, 'b'), reinaNegra.getPosicion(), POSICION_NO_ESPERADA);
		reinaNegra.mover(Direccion.NOROESTE, 1);
		assertEquals(new Posicion(7, 'a'), reinaNegra.getPosicion(), POSICION_NO_ESPERADA);
		reinaNegra.mover(Direccion.NORTE, 1);
		assertEquals(new Posicion(8, 'a'), reinaNegra.getPosicion(), POSICION_NO_ESPERADA);
	}
	
	@Test
	void toStringImprimeCorrectamente() {
		assertEquals("color=Blanco, posicion=(fila=1, columna=d)", reinaBlanca.toString(), CADENA_NO_ESPERADA);
	}

}
