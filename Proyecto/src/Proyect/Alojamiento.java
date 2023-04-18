package Proyect;

import java.util.Scanner;

public abstract class Alojamiento {

	
	/*********** ATRIBUTOS *****************/

	protected String cod_al;
	protected String ubicacion;
	protected double precio_al;
	protected int ocupado;

	/********* CONSTRUCTORES ***************/

	public Alojamiento() {

	}

	public Alojamiento(String c, String u, double p, int o) {
		this.cod_al = c;
		this.ubicacion = u;
		this.precio_al = p;
		this.ocupado = o;
	}

	public Alojamiento(Alojamiento a) {
		this.cod_al = a.cod_al;
		this.ubicacion = a.ubicacion;
		this.precio_al = a.precio_al;
		this.ocupado = a.ocupado;
	}

	/************* METODOS **************/

	public String getCod_al() {
		return cod_al;
	}

	public void setCod_al(String cod_al) {
		this.cod_al = cod_al;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public double getPrecio_al() {
		return precio_al;
	}

	public void setPrecio_al(double precio_al) {
		this.precio_al = precio_al;
	}

	public int getOcupado() {
		return ocupado;
	}

	public void setOcupado(int ocupado) {
		this.ocupado = ocupado;
	}
	

	@Override
	public String toString() {
		return "Alojamiento [cod_al=" + cod_al + ", ubicacion=" + ubicacion + ", precio_al=" + precio_al + ", ocupado="
				+ ocupado + "]";
	}

	public abstract boolean es_apto();
	public abstract void printCaracteristicas();
	public abstract void leer(Scanner teclado);
}
