package Proyect;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Apartamento
 * 
 * @author Grupo9
 * 
 */
public class Apartamento extends Alojamiento implements Facturacion {

	private int num_dormitorios;

	/**
	 * Constructor por defecto
	 */
	public Apartamento() {

	}

	/**
	 * Constructor personalizado
	 * 
	 * @param c Codigo_alojamiento
	 * @param u Ubicacion
	 * @param p Precio
	 * @param o Ocupado
	 * @param n Numero de dormitorios
	 */
	public Apartamento(int c, String u, double p, int o, int n) {
		super(c, u, p, o);
		this.num_dormitorios = n;
	}

	/**
	 * Constructor copia
	 * 
	 * @param a Nuevo Apartamento
	 */
	public Apartamento(Apartamento a) {
		super(a);
		this.num_dormitorios = a.num_dormitorios;
	}

	/************* GETTERS/SETTERS *****************/

	public int getNum_dormitorios() {
		return num_dormitorios;
	}

	public void setNum_dormitorios(int num_dormitorios) {
		this.num_dormitorios = num_dormitorios;
	}

	/**
	 * Metodo para comprobar si el apartamento es apto o no dependiendo del numero
	 * de dormitorios
	 * 
	 * @return boolean indicandonos si es apto o no
	 */
	@Override
	public boolean es_apto() {
		if (num_dormitorios > 0 && num_dormitorios < 6) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que devuelve las caracteristicas del apartamento
	 * 
	 * @return String con las caracteristicas
	 */
	@Override
	public String printCaracteristicas() {

		String caracteristicas = cod_al + ubicacion + precio_al + ocupado + num_dormitorios;
		return caracteristicas;

	}

	/**
	 * Metodo para introducir los datos del apartamento
	 * 
	 * @param teclado
	 */
	@Override
	public void leer(Scanner teclado) {
		System.out.println("Codigo Apartamento: ");
		cod_al = teclado.nextInt();
		System.out.println("Ubicacion: ");
		ubicacion = teclado.next();
		teclado.nextLine();
		System.out.println("Precio: ");
		precio_al = teclado.nextDouble();
		System.out.println("¿ Esta ocupado ? ");
		ocupado = teclado.nextInt();
		System.out.println("Numero de dormitorios");
		num_dormitorios = teclado.nextInt();

	}

	/**
	 * Metodo para calcular el precio Total del apartamento
	 * 
	 * @return double Total precio
	 */
	@Override
	public double setTotal() {
		double tot = precio_al + precio_al * IVA;
		return tot;
	}

}
