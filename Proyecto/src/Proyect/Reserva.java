package Proyect;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;;

/**
 * Reserva
 * 
 * @author grupo9
 *
 */
public class Reserva {

	private int cod_re;
	private Date fecha_ida;
	private Date fecha_vuelta;
	private String dni_usuario;
	private int cod_al;
	private int cod_tra;

	/**
	 * Constructor por defecto
	 */
	public Reserva() {

	}

	/**
	 * Constructor personalizado
	 * 
	 * @param c  Codigo_reserva
	 * @param fi fecha_ida
	 * @param fv fecha_vuelta
	 * @param d  DNI
	 * @param ca cod_alojamiento
	 * @param ct cod_transporte
	 */
	public Reserva(int c, Date fi, Date fv, String d, int ca, int ct) {
		this.cod_re = c;
		this.fecha_ida = fi;
		this.fecha_vuelta = fv;
		this.dni_usuario = d;
		this.cod_al = ca;
		this.cod_tra = ct;
	}

	/**
	 * Consctructor copia
	 * 
	 * @param r Nueva Reserva
	 */
	public Reserva(Reserva r) {
		this.cod_re = r.cod_re;
		this.fecha_ida = r.fecha_ida;
		this.fecha_vuelta = r.fecha_vuelta;
		this.dni_usuario = r.dni_usuario;
		this.cod_al = r.cod_al;
		this.cod_tra = r.cod_tra;
	}

	/*********** GETTERS/SETTERS ***************/

	@Override
	public String toString() {
		return "Reserva [cod_re=" + cod_re + ", fecha_ida=" + fecha_ida + ", fecha_vuelta=" + fecha_vuelta
				+ ", dni_usuario=" + dni_usuario + ", cod_al=" + cod_al + ", cod_tra=" + cod_tra + "]";
	}

	public int getCod_re() {
		return cod_re;
	}

	public void setCod_re(int cod_re) {
		this.cod_re = cod_re;
	}

	public Date getFecha_ida() {
		return fecha_ida;
	}

	public void setFecha_ida(Date fecha_ida) {
		this.fecha_ida = fecha_ida;
	}

	public Date getFecha_vuelta() {
		return fecha_vuelta;
	}

	public void setFecha_vuelta(Date fecha_vuelta) {
		this.fecha_vuelta = fecha_vuelta;
	}

	public String getDni_usuario() {
		return dni_usuario;
	}

	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}

	public int getCod_al() {
		return cod_al;
	}

	public void setCod_al(int cod_al) {
		this.cod_al = cod_al;
	}

	public int getCod_tra() {
		return cod_tra;
	}

	public void setCod_tra(int cod_tra) {
		this.cod_tra = cod_tra;
	}

	/**
	 * Metodo leer
	 * 
	 * @param teclado
	 */
	public void leer(Scanner teclado) {
		System.out.println("Fecha_ida: ");
		try {
			String fecha = teclado.nextLine();
			Date date = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = simpleDateFormat.parse(fecha);
			String f = simpleDateFormat.format(date);
			java.sql.Date d1 = java.sql.Date.valueOf(f);
			fecha_ida = d1;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR, introduce una fecha válida");
		}
		System.out.println("Fecha_vuelta: ");
		try {
			String fecha = teclado.nextLine();
			Date date = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = simpleDateFormat.parse(fecha);
			String f = simpleDateFormat.format(date);
			java.sql.Date d1 = java.sql.Date.valueOf(f);
			fecha_vuelta = d1;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR, introduce una fecha válida");
		}
		System.out.println("DNI_Usuario: ");
		dni_usuario = teclado.next();
		System.out.println("Codigo Alojamiento: ");
		cod_al = teclado.nextInt();
		System.out.println("Codigo Transporte: ");
		cod_tra = teclado.nextInt();
	}

}
