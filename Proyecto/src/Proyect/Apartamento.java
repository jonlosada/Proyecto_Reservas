package Proyect;

import java.util.Scanner;

public class Apartamento extends Alojamiento implements Facturacion {

	private int num_dormitorios;

	public Apartamento() {
		
	}
	
	public Apartamento(String c, String u, double p, int o, int n) {
		super(c,u,p,o);
		this.num_dormitorios = n;
	}

	public Apartamento(Apartamento a) {
		super(a);
		this.num_dormitorios = a.num_dormitorios;
	}
	
	/**********************************************/
	
	public int getNum_dormitorios() {
		return num_dormitorios;
	}

	public void setNum_dormitorios(int num_dormitorios) {
		this.num_dormitorios = num_dormitorios;
	}
	
		
	@Override
	public boolean es_apto() {
		if(num_dormitorios > 0 && num_dormitorios < 6) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void printCaracteristicas() {
		System.out.println("Codigo Apartamento: " + cod_al );
		System.out.println("Precio Apartamento: " + precio_al );
		System.out.println("Ubicacion Apartamento: " + ubicacion );
		System.out.println("Ocupado: " + ocupado);
		System.out.println("Num. Dormitorios: " + num_dormitorios);		
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
		System.out.println("Numero de dormitorios: ");
		num_dormitorios = teclado.nextInt();
		
	}

	@Override
	public double setTotal() {
		double tot = precio_al + precio_al * IVA;
		return tot;
	}


	
}
