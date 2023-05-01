package Proyect;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

/**
 * Empleado
 * 
 * @author grupo9
 *
 */
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email;
	private String dni_empleado;

	/**
	 * Constructor por defecto
	 */

	public Empleado() {

	}

	/**
	 * Constructor copia
	 * 
	 * @param e Empleado nuevo
	 */
	public Empleado(Empleado e) {
		this.nombre = e.nombre;
		this.apellido1 = e.apellido1;
		this.apellido2 = e.apellido2;
		this.email = e.email;
		this.dni_empleado = e.dni_empleado;
	}

	/**
	 * Constructor personalizado
	 * 
	 * @param n  Nombre
	 * @param a1 Apellido1
	 * @param a2 Apellido2
	 * @param e  Email
	 * @param d  DNI
	 */
	public Empleado(String n, String a1, String a2, String e, String d) {

		this.nombre = n;
		this.apellido1 = a1;
		this.apellido2 = a2;
		this.email = e;
		this.dni_empleado = d;
	}

	/** GETTERS/SETTERS **/

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

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", email="
				+ email + ", dni_empleado=" + dni_empleado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, dni_empleado, email, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(apellido1, other.apellido1) && Objects.equals(apellido2, other.apellido2)
				&& Objects.equals(dni_empleado, other.dni_empleado) && Objects.equals(email, other.email)
				&& Objects.equals(nombre, other.nombre);
	}

	/**********************************************/

	/**
	 * Metodo leer
	 * 
	 * @param teclado
	 */
	public void leer(Scanner teclado) {
		System.out.println("Nombre: ");
		nombre = teclado.next();
		System.out.println("Apellido1: ");
		apellido1 = teclado.next();
		System.out.println("Apellido2: ");
		apellido2 = teclado.next();
		System.out.println("Email: ");
		email = teclado.next();
		System.out.println("DNI_empleado: ");
		dni_empleado = teclado.next();
	}
}
