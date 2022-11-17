package org.iesalandalus.programacion.reinaajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reinaajedrez.modelo.Reina;


public class MainApp {
	private static Reina reina;
	
	public static void main(String[] args) {
		int opcion;
		do {
		opcion = Consola.elegirOpcionMenu();
		ejecutarOpcion(opcion);
		}while(opcion != 4);
		
	}
	
	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1: crearReinaDefecto();
		mostrarReina();
			break;
		case 2: crearReinaColor();
		mostrarReina();
			break;
		case 3: mover();
		mostrarReina();
			break;
		case 4:Consola.despedirse();
			break;
		default:

		}
	
	}
	
	private static void crearReinaDefecto () {
		reina = new Reina();
	}
	
	private static void crearReinaColor () {
		reina = new Reina(Consola.elegirColor());
	}
	
	private static void mover() {
		if(reina == null) {
			throw new IllegalArgumentException("ERROR: La reina no existe");
		}
		Consola.mostrarMenuDirecciones();
		try {
			reina.mover(Consola.elegirDireccion(),Consola.elegirPasos());
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	private static void mostrarReina() {
		if(reina == null) {
			System.out.println("La reina no existe");
		}
		else {
			System.out.println(reina);
		}
	}
	
	
	
	
	
}
