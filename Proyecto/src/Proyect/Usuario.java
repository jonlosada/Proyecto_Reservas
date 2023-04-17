package Proyect;

import java.util.Scanner;

public class Usuario {
	private String dni_usuario;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefono;
	private String email;

	
	public Usuario() {
		
	}

	public Usuario(String d, String n, String a1, String a2, String t, String e) {
		this.dni_usuario = d;
		this.nombre = n;
		this.apellido1 = a1;
		this.apellido2 = a2;
		this.telefono = t;
		this.email = e;
		
	}
	
	public Usuario(Usuario u) {
		this.dni_usuario = u.dni_usuario;
		this.nombre = u.nombre;
		this.apellido1 = u.apellido1;
		this.apellido2 = u.apellido2;
		this.telefono = u.telefono;
		this.email = u.email;
	}
	
	
	public String getDni_usuario() {
		return dni_usuario;
	}

	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		return dni_usuario;
	}

	public void setDni_empleado(String dni_empleado) {
		this.dni_usuario = dni_empleado;
	}

	
	
	public void leer(Scanner teclado ) {
		System.out.println("DNI: ");
		this.dni_usuario = teclado.next();
		System.out.println("Nombre: ");
		this.nombre = teclado.next();
		System.out.println("Apellido1: ");
		this.apellido1 = teclado.next();
		System.out.println("Apellido2: ");
		this.apellido2 = teclado.next();
		System.out.println("Telefono: ");
		this.telefono = teclado.next();
		System.out.println("Email: ");
		this.email = teclado.next();
	}

	@Override
	public String toString() {
		return "Usuario [dni_usuario=" + dni_usuario + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", telefono=" + telefono + ", email=" + email + "]";
	}
	
	
	
}
