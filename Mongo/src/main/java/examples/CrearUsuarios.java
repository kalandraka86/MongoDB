package examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CrearUsuarios {

	private static List<Usuario> usuarios = new ArrayList<>();
	private static File f = new File("files/usuarios");

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		usuarios.add(new Usuario("admin", "a1234"));
		usuarios.add(new Usuario("incorrecto", "i1234"));
		usuarios.add(new Usuario("raulito", "c++"));

		escribirFicheroBin(usuarios);
		leerUsuariosBin();
	}

	private static void leerUsuariosBin() throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

		List<Usuario> leer = (List<Usuario>) ois.readObject();

		System.out.println(leer);

	}

	private static void escribirFicheroBin(List<Usuario> u) throws FileNotFoundException, IOException {

		if (!f.exists()) {
			f.createNewFile();
		}

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

		oos.writeObject(usuarios);

		oos.close();
		System.out.println("Archivo usuarios generado");
	}

}
