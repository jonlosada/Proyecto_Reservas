package Proyect;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;;

public class Reserva{

	private String cod_re;
	private Date fecha_ida;
	private Date fecha_vuelta;
	private String dni_usuario;
	private String cod_al;
	private String cod_tra;
	
	public Reserva() {
		
	}
	
	public Reserva( String c, Date fi, Date fv, String d, String ca, String ct) {
		this.cod_re = c;
		this.fecha_ida = fi;
		this.fecha_vuelta = fv;
		this.dni_usuario = d;
		this.cod_al = ca;
		this.cod_tra = ct;
	}
	
	public Reserva(Reserva r) {
		this.cod_re = r.cod_re;
		this.fecha_ida = r.fecha_ida;
		this.fecha_vuelta = r.fecha_vuelta;
		this.dni_usuario = r.dni_usuario;
		this.cod_al = r.cod_al;
		this.cod_tra = r.cod_tra;
	}
	
	/**********************************************/
	
	
	
	public String getCod_re() {
		return cod_re;
	}
	public String getCod_al() {
		return cod_al;
	}

	public void setCod_al(String cod_al) {
		this.cod_al = cod_al;
	}

	public String getCod_tra() {
		return cod_tra;
	}

	public void setCod_tra(String cod_tra) {
		this.cod_tra = cod_tra;
	}

	public void setCod_re(String cod_re) {
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

	

	@Override
	public String toString() {
		return "Reserva [cod_re=" + cod_re + ", fecha_ida=" + fecha_ida + ", fecha_vuelta=" + fecha_vuelta
				+ ", dni_usuario=" + dni_usuario + ", cod_al=" + cod_al + ", cod_tra=" + cod_tra + "]";
	}

	public void leer( Scanner teclado )  {
		System.out.println("Codigo: ");
		cod_re = teclado.next();
		teclado.nextLine();
		System.out.println("Fecha_ida: ");
		try {
			String fecha = teclado.nextLine();
			Date date = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = simpleDateFormat.parse(fecha);
			String f = simpleDateFormat.format(date);
			java.sql.Date d1 = java.sql.Date.valueOf(f);
			fecha_ida = d1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			e.printStackTrace();
		}
		System.out.println("DNI_Usuario: ");
		dni_usuario = teclado.next();
		System.out.println("Codigo Alojamiento: ");
		cod_al = teclado.next();
		System.out.println("Codigo Transporte: ");
		cod_tra = teclado.next();
	}
	
}
