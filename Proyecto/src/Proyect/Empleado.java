package Proyect;

import java.io.Serializable;

public class Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email;
	private String dni_empleado;

	public Empleado() {

	}

	public Empleado(String n, String a1, String a2, String e, String d) {
		
		this.nombre = n;
		this.apellido1 = a1;
		this.apellido2 = a2;
		this.email = e;
		this.dni_empleado = d;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni_empleado() {
		return dni_empleado;
	}

	public void setDni_empleado(String dni_empleado) {
		this.dni_empleado = dni_empleado;
	}

	/**********************************************/

}
