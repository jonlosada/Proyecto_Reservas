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
import java.util.Date;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import logs.HTMLFormat;

public class GestionReserva {

	private static final Logger LOGGER = Logger.getLogger(GestionReserva.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
		ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
		ArrayList<Transporte> transportes = new ArrayList<Transporte>();
		boolean modificadoE = false;
		boolean modificadoR = false;
		boolean modificadoU = false;
		boolean modificadoA = false;
		boolean modificadoT = false;
		boolean modificadoH = false;
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
				reservas.add(new Reserva(rs.getInt("cod_re"), rs.getDate("fech_ida"), rs.getDate("fech_vuelta"),
						rs.getString("dni_usuario"), rs.getInt("cod_al"), rs.getInt("cod_tra")));
			}
			rs = st.executeQuery("SELECT * FROM transporte");
			while (rs.next()) {
				transportes.add(new Transporte(rs.getInt("cod_tra"), rs.getInt("lleno"), rs.getString("origen"),
						rs.getString("destino"), rs.getDouble("precio_tra"), rs.getString("tipo")));
			}
			rs = st.executeQuery("SELECT * FROM hotel");
			while (rs.next()) {
				hoteles.add(new Hotel(rs.getInt("cod_al"), rs.getString("ubicacion"), rs.getDouble("precio_ap"), 
						rs.getInt("ocupado"), rs.getInt("estrellas")));
			}
			rs = st.executeQuery("SELECT * FROM apartamento");
			while (rs.next()) {
				apartamentos.add(new Apartamento(rs.getInt("cod_al"), rs.getString("ubicacion"), rs.getDouble("precio_ap"), 
						rs.getInt("ocupado"), rs.getInt("num_dormitorios")));
			}
			st.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			configurarLog();
			LOGGER.log(Level.FINE, "Error de conexión");
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
					" 5- Añadir Empleado                                                            		  ");
			System.out.println(
					" --------------------------------------------------------------------------------------------");
			System.out.println(
					" 6- Listar Reservas                                                                         ");
			System.out.println(
					" 7- Listar Usuarios                                                                         ");
			System.out.println(
					" 8- Listar Transportes                                                                      ");
			System.out.println(
					" 9- Listar Alojamientos                                                                     ");
			System.out.println(
					" --------------------------------------------------------------------------------------------");
			System.out.println(
					" 10-  Modificar Reserva                                                                      ");
			System.out.println(
					" --------------------------------------------------------------------------------------------");
			System.out.println(
					" 11- Borrar Reserva                                                                         ");
			System.out.println(
					" --------------------------------------------------------------------------------------------");
			System.out.println(
					" 12- Visualizar Reservas de un Usuario                                                      ");
			System.out.println(
					" --------------------------------------------------------------------------------------------");
			System.out.println(
					" 13- Calcular precio total de una reserva                                                    ");
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
					if (transportes.get(i).getCod_tra() == r.getCod_tra()) {
						añadido2 = true;
					}
				}
				for (int i = 0; i < hoteles.size(); i++) {
					if (hoteles.get(i).getCod_al() == r.getCod_al()) {
						añadido3 = true;
					}
				}
				for (int i = 0; i < apartamentos.size(); i++) {
					if (apartamentos.get(i).getCod_al() == r.getCod_al()) {
						añadido3 = true;
					}
				}
				if (añadido1 && añadido2 && añadido3) {
					if (!reservas.contains(r)) {
						reservas.add(new Reserva((reservas.size()+1), r.getFecha_ida(),r.getFecha_vuelta(),r.getDni_usuario(), r.getCod_al(), r.getCod_tra()));
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
					configurarLog2("Case 2");
					LOGGER.log(Level.FINE, "Usuario añadido");
				}
				modificadoU = true;
				break;
			case 3:
				t.leer(teclado);
				if (!transportes.contains(t)) {
					transportes.add(new Transporte((transportes.size()+1),t.getLleno(), t.getOrigen(), t.getDestino(), t.getPrecio(), t.getTipo()));
				}
				modificadoT = true;
				for(int i=0; i<transportes.size(); i++) {
					System.out.println(transportes.get(i));
				}
				break;
			case 4:
				System.out.println("Indica si quiere un hotel o apartamento: ");
				String nombre = teclado.next();
				if(nombre.equalsIgnoreCase("hotel")) {
					h.leer(teclado);
					if (!hoteles.contains(h)) {
						hoteles.add(new Hotel(h));
					}
					modificadoH = true;
				} else if ( nombre.equalsIgnoreCase("apartamento")) {
					a.leer(teclado);
					if(!apartamentos.contains(a)) {
						apartamentos.add(new Apartamento(a));
					}
					modificadoA = true;
				}
				break;

			case 5:
				Empleado em1 = new Empleado();
				em1.leer(teclado);
				if (!empleados.contains(em1)) {
					empleados.add(new Empleado(em1));
				}
				modificadoE = true;
				break;
			case 6:
				for (int i = 0; i < reservas.size(); i++) {
					System.out.println(reservas.get(i));
				}
				break;

			case 7:
				for (int i = 0; i < usuarios.size(); i++) {
					System.out.println(usuarios.get(i));
				}
				break;

			case 8:
				for (int i = 0; i < transportes.size(); i++) {
					System.out.println(transportes.get(i));
				}
				break;

			case 9:
				for (int i = 0; i < hoteles.size(); i++) {
					System.out.println(hoteles.get(i));
				}
				for (int i = 0; i < apartamentos.size(); i++) {
					System.out.println(apartamentos.get(i));
				}
				break;
			case 10:
				System.out.println("Introduce el codigo de la reserva que quiere modificar: ");
				int cod = teclado.nextInt();
				for (int i = 0; i < reservas.size(); i++) {
					if (reservas.get(i).getCod_re() == cod) {
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
			case 11:
				System.out.println("Introduce el codigo de la reserva que quiere borrar: ");
				cod = teclado.nextInt();
				for (int i = 0; i < reservas.size(); i++) {
					if (reservas.get(i).getCod_re() == cod) {
						reservas.remove(i);
					}
				}
				modificadoR = true;
				break;
			case 12:
				System.out.println("Introduce el DNI del usuario: ");
				String dnii = teclado.next();
				boolean existe = false;
				for (int i = 0; i < reservas.size(); i++) {
					if (usuarios.get(i).getDni_usuario().equals(dnii)) {
						existe = true;
					}
				}
				if(!existe) {
					System.out.println("Ese DNI no existe");
				} else {
					for (int i = 0; i < reservas.size(); i++) {
						if (reservas.get(i).getDni_usuario().equals(dnii)) {
							System.out.println(reservas.get(i));
						}
					}
				}
				modificadoR = true;
				break;
			case 13:
				System.out.println("Introduce el codigo de la reserva: ");
				boolean existe2 = false;
				int codigo = teclado.nextInt();
				int codigo_al = 0;
				int codigo_tra = 0;
				double precio_total = 0.0;
				for(int i=0; i<reservas.size(); i++) {
					if(reservas.get(i).getCod_re() == codigo) {
						existe2 = true;
						codigo_al = reservas.get(i).getCod_al();
						codigo_tra = reservas.get(i).getCod_tra();
					} 
				}
				if(!existe2) {
					System.out.println("Esa reserva no existe!");
				} else {
					for(int i=0; i<hoteles.size(); i++) {
						if(hoteles.get(i).getCod_al() == codigo_al) {
							precio_total = precio_total + hoteles.get(i).setTotal();
						}
					}
					for(int i=0; i<apartamentos.size(); i++) {
						if(apartamentos.get(i).getCod_al() == codigo_al) {
							precio_total = precio_total + apartamentos.get(i).setTotal();
						}
					}
					for(int i=0; i<transportes.size(); i++) {
						if(transportes.get(i).getCod_tra() == codigo_tra) {
							precio_total = precio_total + transportes.get(i).setTotal();
						}
					}
					System.out.println("El precio TOTAL de la reserva es: " + precio_total);
				}
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
				String consulta = "SET FOREIGN_KEY_CHECKS=0";
				st.executeUpdate(consulta);
				consulta = "DELETE from reserva;";
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
							+ d2 + "','" + reservas.get(cont).getDni_usuario() + "','" + reservas.get(cont).getCod_al() + "','" + reservas.get(cont).getCod_tra() + "');";
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

		if (modificadoT) {
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
				Statement st = conexion.createStatement();
				String consulta = "DELETE from transporte;";
				st.executeUpdate(consulta);
				for (int cont = 0; cont < transportes.size(); cont++) {
					consulta = "INSERT INTO transporte VALUES ( '" + transportes.get(cont).getCod_tra() + "',"
							+ transportes.get(cont).getLleno() + ",'" + transportes.get(cont).getOrigen() + "','"
							+ transportes.get(cont).getDestino() + "','" + transportes.get(cont).getPrecio() + "','" + transportes.get(cont).getTipo() + "');";
					st.executeUpdate(consulta);
				}
				st.close();
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (modificadoH) {
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
				Statement st = conexion.createStatement();
				String consulta = "DELETE from hotel;";
				st.executeUpdate(consulta);
				for (int cont = 0; cont < hoteles.size(); cont++) {
					consulta = "INSERT INTO hotel VALUES ( '" + hoteles.get(cont).getCod_al() + "','"
							+ hoteles.get(cont).getUbicacion() + "','" + hoteles.get(cont).getPrecio_al() + "',"
							+ hoteles.get(cont).getOcupado() + "," + hoteles.get(cont).getEstrellas() + ");";
					st.executeUpdate(consulta);
				}
				
				st.close();
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (modificadoA) {
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
				Statement st = conexion.createStatement();
				String consulta = "DELETE from apartamento;";
				st.executeUpdate(consulta);
				for (int cont = 0; cont < hoteles.size(); cont++) {
					consulta = "INSERT INTO apartamento VALUES ( '" + apartamentos.get(cont).getCod_al() + "','"
							+ apartamentos.get(cont).getUbicacion() + "','" + apartamentos.get(cont).getPrecio_al() + "',"							+ apartamentos.get(cont).getOcupado() + "," + apartamentos.get(cont).getNum_dormitorios() + ");";
					st.executeUpdate(consulta);
				}
				
				st.close();
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	}
	public static void configurarLog() {
		LOGGER.setUseParentHandlers(false);
		Handler fileHandler = null;
		try {
			fileHandler = new FileHandler("./logs/ficheroLog.log", true);
		} catch( IOException e) {
			e.printStackTrace();
		}
		LOGGER.addHandler(fileHandler);
		fileHandler.setLevel(Level.ALL);
		LOGGER.setLevel(Level.ALL);
	}
	
	public static void configurarLog2(String nombre) {
		LOGGER.setUseParentHandlers(false);
		Handler fileHandler = null;
		try {
			fileHandler = new FileHandler("./logs/" + nombre);
		} catch( IOException e) {
			e.printStackTrace();
		}
		LOGGER.addHandler(fileHandler);
		fileHandler.setLevel(Level.ALL);
		fileHandler.setFormatter(new HTMLFormat());
		LOGGER.setLevel(Level.ALL);
	}

}
