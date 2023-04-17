package Proyect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class GestionReserva {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
		ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
		ArrayList<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
		ArrayList<Transporte> transportes = new ArrayList<Transporte>();
		boolean modificadoE = false;
		boolean modificadoR = false;
		boolean modificadoU = false;
		boolean modificadoA = false;
		boolean modificadoT = false;
		Empleado em = new Empleado();
		Reserva r = new Reserva();
		Usuario u = new Usuario();
		Transporte t = new Transporte();
		Hotel h = new Hotel();
		Apartamento a = new Apartamento();
		try {
			ResultSet rs;
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
			Statement st = conexion.createStatement();
			rs = st.executeQuery("SELECT * FROM usuario");
			while (rs.next()) {
				usuarios.add(new Usuario(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("email"), rs.getString("telefono")));
			}
			rs = st.executeQuery("SELECT * FROM reserva");
			while (rs.next()) {
				reservas.add(new Reserva(rs.getString("cod_re"), rs.getDate("fecha_ida"), rs.getDate("fecha_vuelta"),
						rs.getString("dni_usuario"), rs.getString("cod_al"), rs.getString("cod_tra")));
			}
			rs = st.executeQuery("SELECT * FROM transporte");
			while (rs.next()) {
				transportes.add(new Transporte(rs.getString("cod_tra"), rs.getInt("lleno"), rs.getString("origen"),
						rs.getString("destino"), rs.getDouble("precio")));
			}
			rs = st.executeQuery("SELECT * FROM hotel");
			while (rs.next()) {
				hoteles.add(new Hotel(rs.getString("cod_al"), rs.getString("ubicacion"), rs.getDouble("precio_al"), 
						rs.getInt("ocupado"), rs.getInt("estrellas")));
			}
			rs = st.executeQuery("SELECT * FROM apartamento");
			while (rs.next()) {
				apartamentos.add(new Apartamento(rs.getString("cod_al"), rs.getString("ubicacion"), rs.getDouble("precio_al"), 
						rs.getInt("ocupado"), rs.getInt("num_dormitorios")));
			}
			st.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error de Conexión");
		}

		try {
			FileInputStream fis = new FileInputStream("empleado.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (fis.available() > 0) {
				em = (Empleado) ois.readObject();
				empleados.add(em);
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Bienvenido a la agencia de viajes");
		System.out.println("¿Cual es tu numero de DNI?");
		String dni = teclado.next();
		boolean encontrado = false;
		while (!encontrado) {
			for (int i = 0; i < empleados.size(); i++) {
				if (empleados.get(i).getDni_empleado().equals(dni)) {
					encontrado = true;
				}
			}
			if (!encontrado) {
				System.out.println("Ese empleado no existe, introduce de nuevo tu DNI: ");
				dni = teclado.next();
			} else {
				System.out.println("Bienvenido!");
			}
		}
		int opcion;
		do {

			System.out.println(
					"=============================================================================================");
			System.out.println(
					" 1- Crear Reserva Definitiva ( Primero añadir el usuario, alojamiento y transporte )        ");
			System.out.println(
					" 2- Añadir Usuario                                                                          ");
			System.out.println(
					" 3- Añadir Transporte                                                                       ");
			System.out.println(
					" 4- Añadir Alojamiento                                                            		  ");
			System.out.println(
					" --------------------------------------------------------------------------------------------");
			System.out.println(
					" 5- Listar Reservas                                                                         ");
			System.out.println(
					" 6- Listar Usuarios                                                                         ");
			System.out.println(
					" 7- Listar Transportes                                                                      ");
			System.out.println(
					" 8- Listar Alojamientos                                                                     ");
			System.out.println(
					" --------------------------------------------------------------------------------------------");
			System.out.println(
					" 9-  Modificar Reserva                                                                      ");
			System.out.println(
					" 10- Modificar Usuario                                                                      ");
			System.out.println(
					" 11- Modificar Transporte                                                                   ");
			System.out.println(
					" 12- Modificar Alojamiento                                                                  ");
			System.out.println(
					" --------------------------------------------------------------------------------------------");
			System.out.println(
					" 13- Borrar Reserva                                                                         ");
			System.out.println(
					" --------------------------------------------------------------------------------------------");
			System.out.println(
					" 14- Visualizar Reservas de un Usuario                                                      ");
			System.out.println(
					" --------------------------------------------------------------------------------------------");
			System.out.println(
					" 0- Salir                                                                                   ");
			System.out.println(
					"=============================================================================================");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Realiza tu reserva: ");
				r.leer(teclado);
				boolean añadido1 = false;
				boolean añadido2 = false;
				boolean añadido3 = false;
				for (int i = 0; i < usuarios.size(); i++) {
					if (usuarios.get(i).getDni_usuario().equals(r.getDni_usuario())) {
						añadido1 = true;
					}
				}
				for (int i = 0; i < transportes.size(); i++) {
					if (transportes.get(i).getCod_tra().equals(r.getCod_tra())) {
						añadido2 = true;
					}
				}
				for (int i = 0; i < alojamientos.size(); i++) {
					if (alojamientos.get(i).getCod_al().equals(r.getCod_al())) {
						añadido3 = true;
					}
				}
				if (añadido1 && añadido2 && añadido3) {
					if (!reservas.contains(r)) {
						reservas.add(new Reserva(r));
					}
				} else {
					System.out.println(
							"El usuario, transporte o alojamiento no existen. Introduce bien los datos, por favor");
				}
				modificadoR = true;
				break;
			case 2:
				u.leer(teclado);
				if (!usuarios.contains(u)) {
					usuarios.add(new Usuario(u));
				}
				modificadoU = true;
				break;
			case 3:
				t.leer(teclado);
				if (!transportes.contains(t)) {
					transportes.add(new Transporte(t));
				}
				modificadoT = true;
				break;
			case 4:
				System.out.println("Hotel: ");
				h.leer(teclado);
				if (!alojamientos.contains(t)) {
				}
				modificadoA = true;
				break;

			case 5:
				for (int i = 0; i < reservas.size(); i++) {
					System.out.println(reservas.get(i));
				}
				break;

			case 6:
				for (int i = 0; i < usuarios.size(); i++) {
					System.out.println(usuarios.get(i));
				}
				break;

			case 7:
				for (int i = 0; i < transportes.size(); i++) {
					System.out.println(transportes.get(i));
				}
				break;

			case 8:

				break;
			case 9:
				System.out.println("Introduce el codigo de la reserva que quiere modificar: ");
				String cod = teclado.next();
				for (int i = 0; i < reservas.size(); i++) {
					if (reservas.get(i).getCod_re().equals(cod)) {
						System.out.println("Nueva fecha_ida: ");
						try {
							Date date = new SimpleDateFormat("yyyy-MM-dd").parse(teclado.next());
							reservas.get(i).setFecha_ida(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Nueva fecha_vuelta: ");
						try {
							Date date = new SimpleDateFormat("yyyy-MM-dd").parse(teclado.next());
							reservas.get(i).setFecha_vuelta(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				modificadoR = true;
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				break;
			case 13:
				System.out.println("Introduce el codigo de la reserva que quiere borrar: ");
				cod = teclado.next();
				for (int i = 0; i < reservas.size(); i++) {
					if (reservas.get(i).getCod_re().equals(cod)) {
						reservas.remove(i);
					}
				}
				modificadoR = true;
				break;
			case 14:
				break;

			case 0:
				System.out.println("SALIENDO...");

				break;
			}
		} while (opcion != 0);

		if (modificadoE) {

			try {

				FileOutputStream fos = new FileOutputStream("empleado.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for (int posicion = 0; posicion < empleados.size(); posicion++) {
					oos.writeObject(empleados.get(posicion));
				}
				oos.close();
				fos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (modificadoU) {
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
				Statement st = conexion.createStatement();
				String consulta = "SET FOREIGN_KEY_CHECKS=0";
				st.executeUpdate(consulta);
				consulta = "DELETE from usuario;";
				st.executeUpdate(consulta);
				for (int cont = 0; cont < usuarios.size(); cont++) {
					consulta = "INSERT INTO usuario VALUES ( '" + usuarios.get(cont).getDni_usuario() + "','"
							+ usuarios.get(cont).getNombre() + "','" + usuarios.get(cont).getApellido1() + "','"
							+ usuarios.get(cont).getApellido2() + "','" + usuarios.get(cont).getTelefono() + "','"
							+ usuarios.get(cont).getEmail() + "');";
					st.executeUpdate(consulta);
				}
				consulta = "SET FOREIGN_KEY_CHECKS=1";
				st.executeUpdate(consulta);
				st.close();
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (modificadoR) {
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
				Statement st = conexion.createStatement();
				String consulta = "DELETE from reserva;";
				st.executeUpdate(consulta);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

				for (int cont = 0; cont < reservas.size(); cont++) {
					Date d = reservas.get(cont).getFecha_ida();
					String f = simpleDateFormat.format(d);
					java.sql.Date d1 = java.sql.Date.valueOf(f);
					d = reservas.get(cont).getFecha_vuelta();
					f = simpleDateFormat.format(d);
					java.sql.Date d2 = java.sql.Date.valueOf(f);
					consulta = "INSERT INTO reserva VALUES ( '" + reservas.get(cont).getCod_re() + "','" + d1 + "','"
							+ d2 + "','" + reservas.get(cont).getDni_usuario() + "');";
					st.executeUpdate(consulta);
				}
				st.close();
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (modificadoT) {
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
				Statement st = conexion.createStatement();
				String consulta = "DELETE from transporte;";
				st.executeUpdate(consulta);
				for (int cont = 0; cont < transportes.size(); cont++) {
					consulta = "INSERT INTO transporte VALUES ( '" + transportes.get(cont).getCod_tra() + "',"
							+ transportes.get(cont).getLleno() + ",'" + transportes.get(cont).getOrigen() + "','"
							+ transportes.get(cont).getDestino() + "','" + transportes.get(cont).getPrecio() + "');";
					st.executeUpdate(consulta);
				}
				st.close();
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
