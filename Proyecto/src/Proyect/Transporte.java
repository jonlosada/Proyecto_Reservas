package Proyect;

import java.util.Date;
import java.util.Scanner;

public class Transporte implements Facturacion  {

	private int cod_tra;
	private int lleno;
	private String Origen;
	private String Destino;
	private double precio;
	private String tipo;

	
	public Transporte() {
		
	}
	
	public Transporte( Transporte t) {
		this.cod_tra = t.cod_tra;
		this.lleno = t.lleno;
		this.Origen = t.Origen;
		this.Destino = t.Destino;
		this.precio = t.precio;
		this.tipo = t.tipo;
	}
	
	public Transporte( int c, int l, String o, String d, double p, String t) {
		this.cod_tra = c;
		this.lleno = l;
		this.Origen = o;
		this.Destino = d;
		this.precio = p;
		this.tipo = t;
	}
	/**********************************************/
	
	
	
	public int getLleno() {
		return lleno;
	}

	public int getCod_tra() {
		return cod_tra;
	}

	public void setCod_tra(int cod_tra) {
		this.cod_tra = cod_tra;
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

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void leer(Scanner teclado) {
		System.out.println("¿ Está lleno ?");
		this.lleno = teclado.nextInt();
		System.out.println("Origen: ");
		this.Origen = teclado.next();
		System.out.println("Destino: ");
		this.Destino = teclado.next();
		teclado.nextLine();
		System.out.println("Precio: ");
		this.precio = teclado.nextDouble();
		System.out.println("Tipo: ");
		this.tipo = teclado.next();
	}

	@Override
	public String toString() {
		return "Transporte [cod_tra=" + cod_tra + ", lleno=" + lleno + ", Origen=" + Origen + ", Destino=" + Destino
				+ ", precio=" + precio + ", tipo=" + tipo + "]";
	}

	@Override
	public double setTotal() {
		double tot = precio + precio * IVA;
		return tot;
	}
	
}
