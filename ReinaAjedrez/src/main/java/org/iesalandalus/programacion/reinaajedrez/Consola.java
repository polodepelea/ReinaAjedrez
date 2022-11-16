package org.iesalandalus.programacion.reinaajedrez;

import org.iesalandalus.programacion.reinaajedrez.modelo.Color;
import org.iesalandalus.programacion.reinaajedrez.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	private Consola() {
		
	}
	
	public static void mostrarMenu() {
		
			System.out.println("\t.:MENU:.");
			System.out.println("1.Crear reina por defecto");
			System.out.println("2.Crear reina elegiendo color");
			System.out.println("3.Mover");
			System.out.println("4.Salir");
	}
	
	public static int elegirOpcionMenu() {
		int opcion;
		do {
		mostrarMenu();
		System.out.println("Elige una opcion: ");
		opcion = Entrada.entero();
		if(opcion>4 || opcion<1){
			System.out.println("Uepa! Esa Opcion no existe");
		}
		}while(opcion>4 || opcion<1);
		return opcion;
	}
	
	public static Color elegirColor() {
		int opcion;
		
		do {
		System.out.println("Elige un color: ");
		System.out.println("1.Negro");
		System.out.println("2.Blanco");
		opcion=Entrada.entero();			
		}while(opcion<1 || opcion>2);
		
		switch (opcion) {
		case 1: 
			return Color.NEGRO;
		case 2:
			return Color.BLANCO;
		default:return Color.BLANCO;
		}
	}
	
	public static void mostrarMenuDirecciones() {
		System.out.println("\t.:MENU DIRECCIONES:.");
		System.out.println("1.NORTE");
		System.out.println("2.NORESTE");
		System.out.println("3.ESTE");
		System.out.println("4.SURESTE");
		System.out.println("5.SUR");
		System.out.println("6.SUROESTE");
		System.out.println("7.OESTE");
		System.out.println("8.NOROESTE");
	}
	
	
	public static Direccion elegirDireccion() {
		int opcion;
		do {
		System.out.println("Elige una opcion: ");
		opcion = Entrada.entero();
		}while(opcion>8 || opcion<1);
		return Direccion.values()[opcion-1];
	}
	
	
	public static int elegirPasos() {
		int pasos;
		System.out.println("Elige la cantidad de pasos(1-7)");
		pasos = Entrada.entero();
		return pasos;
	}
	
	public static void despedirse() {
		System.out.println("HEIPPA!!");
	}
	

}
