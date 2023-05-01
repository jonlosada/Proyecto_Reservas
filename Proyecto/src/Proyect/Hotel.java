package Proyect;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hotel
 * 
 * @author grupo9
 *
 */
public class Hotel extends Alojamiento implements Facturacion {

	private int estrellas;

	/**
	 * Consctructor por defecto
	 */
	public Hotel() {

	}

	/**
	 * Constructor copia
	 * 
	 * @param h Hotel nuevo
	 */
	public Hotel(Hotel h) {
		this.cod_al = h.cod_al;
		this.ubicacion = h.ubicacion;
		this.precio_al = h.precio_al;
		this.ocupado = h.ocupado;
		this.estrellas = h.estrellas;
	}

	/**
	 * Constructor personalizado
	 * 
	 * @param c Codigo_alojamiento
	 * @param u ubicacion
	 * @param p precio
	 * @param o ocupado
	 * @param e estrellas
	 */
	public Hotel(int c, String u, double p, int o, int e) {
		super(c, u, p, o);
		this.estrellas = e;
	}

	/********** SETTERS / GETTERS ***********************/

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	@Override
	public boolean es_apto() {

		if (this.estrellas >= 0 && this.estrellas <= 5) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String printCaracteristicas() {

		String caracteristicas = "" + cod_al + ubicacion + precio_al + ocupado + estrellas + "";
		return caracteristicas;

	}

	@Override
	public void leer(Scanner teclado) {
		System.out.println("Codigo alojamiento: ");
		cod_al = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Ubicacion: ");
		ubicacion = teclado.next();
		teclado.nextLine();
		System.out.println("Precio: ");
		precio_al = teclado.nextDouble();
		System.out.println("¿ Esta ocupado ? ");
		ocupado = teclado.nextInt();
		System.out.println("Numero de estrellas");
		estrellas = teclado.nextInt();
	}

	@Override
	public String toString() {
		return super.toString() + "Hotel [estrellas=" + estrellas + "]";
	}

	@Override
	public double setTotal() {
		double tot = precio_al + precio_al * IVA;
		return tot;
	}
}
