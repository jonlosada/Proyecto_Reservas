package Proyect;

import java.util.Date;
import java.util.Scanner;

public class Transporte implements Facturacion  {

	private String cod_tra;
	private int lleno;
	private String Origen;
	private String Destino;
	private double precio;

	
	public Transporte() {
		
	}
	
	public Transporte( Transporte t) {
		this.cod_tra = t.cod_tra;
		this.lleno = t.lleno;
		this.Origen = t.Origen;
		this.Destino = t.Destino;
		this.precio = t.precio;
	}
	
	public Transporte( String c, int l, String o, String d, double p) {
		this.cod_tra = c;
		this.lleno = l;
		this.Origen = o;
		this.Destino = d;
		this.precio = p;
	}
	/**********************************************/
	
	public String getCod_tra() {
		return cod_tra;
	}
	public void setCod_tra(String cod_tra) {
		this.cod_tra = cod_tra;
	}
	
	public int getLleno() {
		return lleno;
	}

	public void setLleno(int lleno) {
		this.lleno = lleno;
	}

	public String getOrigen() {
		return Origen;
	}
	public void setOrigen(String origen) {
		Origen = origen;
	}
	public String getDestino() {
		return Destino;
	}
	public void setDestino(String destino) {
		Destino = destino;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void leer(Scanner teclado) {
		System.out.println("Codigo_Transporte: ");
		this.cod_tra = teclado.next();
		teclado.nextLine();
		System.out.println("¿ Está lleno ?");
		this.lleno = teclado.nextInt();
		System.out.println("Origen: ");
		this.Origen = teclado.next();
		System.out.println("Destino: ");
		this.Destino = teclado.next();
		teclado.nextLine();
		System.out.println("Precio: ");
		this.precio = teclado.nextDouble();
	}

	@Override
	public String toString() {
		return "Transporte [cod_tra=" + cod_tra + ", lleno=" + lleno + ", Origen=" + Origen + ", Destino=" + Destino
				+ ", precio=" + precio + "]";
	}
	
	public void setTotal ( double t) {
		precio = t;
	}

	@Override
	public double setTotal() {
		double tot = precio + precio * IVA;
		return tot;
	}
	
}
