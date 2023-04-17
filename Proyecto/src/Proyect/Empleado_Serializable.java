package Proyect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Empleado_Serializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		Empleado e1 = new Empleado("Jon", "Losada", "Fernandez", "jon@gmail.com", "44347663Y" );
		Empleado e2 = new Empleado("Uxue", "De", "Oliveira", "jon@gmail.com", "44347663Y" );
		Empleado e3 = new Empleado("Julen", "Losada", "Fernandez", "jon@gmail.com", "44347663Y" );		
		empleados.add(e1);
		empleados.add(e2);
		empleados.add(e3);
				
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

}
