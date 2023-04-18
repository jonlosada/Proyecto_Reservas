package Proyect;

import java.util.Scanner;

public class Hotel extends Alojamiento implements Facturacion {

	private int estrellas;

	public Hotel() {

	}

	public Hotel(Hotel h) {
		this.cod_al = h.cod_al;
		this.ubicacion = h.ubicacion;
		this.precio_al = h.precio_al;
		this.ocupado = h.ocupado;
		this.estrellas = h.estrellas;
	}

	public Hotel(String c, String u, double p, int o, int e) {
		super(c, u, p, o);
		this.estrellas = e;
	}

	/**********************************************/

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
	public void printCaracteristicas() {

		System.out.println("Codigo Hotel: " + cod_al);
		System.out.println("Precio Hotel: " + precio_al);
		System.out.println("Ubicacion Hotel: " + ubicacion);
		System.out.println("Ocupado: " + ocupado);
		System.out.println("Num. Estrellas: " + estrellas);

	}

	@Override
	public void leer(Scanner teclado) {
		System.out.println("Codigo alojamiento: ");
		cod_al = teclado.next();
		System.out.println("Ubicacion: ");
		ubicacion = teclado.next();
		teclado.nextLine();
		System.out.println("Precio: ");
		precio_al = teclado.nextDouble();
		System.out.println("¿ Esta ocupado ? ");
		ocupado = teclado.nextInt();
		System.out.println("Numero de estrellas: ");
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
