package Proyect;

import java.util.Scanner;

/**
 * Alojamiento
 * 
 * @author Grupo9
 */
public abstract class Alojamiento {

	/********* ATRIBUTOS ***************/

	protected int cod_al;
	protected String ubicacion;
	protected double precio_al;
	protected int ocupado;

	/********* CONSTRUCTORES ***********/

	/**
	 * Constructor por defecto
	 */
	public Alojamiento() {

	}

	/**
	 * Constructor personalizado
	 * 
	 * @param c Codigo_alojamiento
	 * @param u Ubicacion
	 * @param p Precio_alojamiento
	 * @param o Ocupado o no-ocupado
	 */
	public Alojamiento(int c, String u, double p, int o) {
		this.cod_al = c;
		this.ubicacion = u;
		this.precio_al = p;
		this.ocupado = o;
	}

	/**
	 * Constructor Copia
	 * 
	 * @param a Nuevo Alojamiento
	 */
	public Alojamiento(Alojamiento a) {
		this.cod_al = a.cod_al;
		this.ubicacion = a.ubicacion;
		this.precio_al = a.precio_al;
		this.ocupado = a.ocupado;
	}

	/************* METODOS **************/

	/** GETTERS/SETTERS **/

	public String getUbicacion() {
		return ubicacion;
	}

	public int getCod_al() {
		return cod_al;
	}

	public void setCod_al(int cod_al) {
		this.cod_al = cod_al;
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

	/**
	 * Metodo que devuelve true o false dependiendo de si el alojamiento es apto o
	 * no
	 * 
	 * @return boolean indicandonos si es apto o no
	 */
	public abstract boolean es_apto();

	/**
	 * Metodo que devuelve las caracteristicas del alojamiento
	 * 
	 * @return String con las caracteristicas
	 */
	public abstract String printCaracteristicas();

	/**
	 * Metodo para introducir los datos del alojamiento
	 * 
	 * @param teclado
	 */
	public abstract void leer(Scanner teclado);

	/**
	 * Metodo para calcular el precio Total del alojamiento
	 * 
	 * @return double Total precio
	 */
	public abstract double setTotal();
}
