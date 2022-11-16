package org.iesalandalus.programacion.reinaajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Reina {
	
	private Color color;
	private Posicion posicion;
	
	
	public Reina() {
		setColor(Color.BLANCO);
		setPosicion(posicion = new Posicion(1,'d'));
	}
	
	public Reina (Color color){
		if (color == null) {
			throw new NullPointerException("ERROR: El color no puede ser nulo.");
		}
		else if(color == Color.BLANCO) {
			setColor(Color.BLANCO);
			setPosicion(posicion = new Posicion(1,'d'));
		}
		else {
			setColor(Color.NEGRO);
			setPosicion(posicion = new Posicion(8,'d'));
		}
	}
	
	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("El color del personaje no puede ser nulo.");
		}
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {
		if (posicion == null) {
			throw new IllegalArgumentException("ERROR: La dirección no puede ser nula.");
		}
		this.posicion = posicion;
	}
	
	
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		if (pasos < 1 || pasos > 7) {
			throw new IllegalArgumentException("ERROR: El número de pasos debe estar comprendido entre 1 y 7.");
		}
		String movimientoNoValido = "ERROR: Movimiento no válido (se sale del tablero).";
		switch (direccion) {
		case NORTE: 
			try {
				setPosicion(new Posicion(posicion.getFila()+pasos,posicion.getColumna()));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException(movimientoNoValido);
			}
			break;
		case NORESTE: 
			
			try {
			setPosicion(new Posicion(posicion.getFila()+pasos,(char)(posicion.getColumna()+pasos)));
			} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException(movimientoNoValido);
			}
			break;
		case ESTE:
			try {
			setPosicion(new Posicion(posicion.getFila(),(char)(posicion.getColumna()+pasos)));
			} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException(movimientoNoValido);
			}
			break;
		case SURESTE:
			try {
			setPosicion(new Posicion(posicion.getFila()-pasos,(char)(posicion.getColumna()+pasos)));
			} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException(movimientoNoValido);
			}
			break;
		case SUR:
			try {
			setPosicion(new Posicion(posicion.getFila()-pasos,(char)(posicion.getColumna())));
			} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException(movimientoNoValido);
			}
			break;
		case SUROESTE: 
			try {
			setPosicion(new Posicion(posicion.getFila()-pasos,(char)(posicion.getColumna()-pasos)));
			} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException(movimientoNoValido);
			}
			break;
		case OESTE:
			try {
			setPosicion(new Posicion(posicion.getFila(),(char)(posicion.getColumna()-pasos)));
			} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException(movimientoNoValido);
			}
			break;
		case NOROESTE:
			try {
			setPosicion(new Posicion(posicion.getFila()+pasos,(char)(posicion.getColumna()-pasos)));
			} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException(movimientoNoValido);
			}
			break;
		}
		}

	@Override
	public String toString() {
		return "color="+color+", posicion=("+posicion+")";
	}
	
	
	
	
	
	
	

}