package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import beans.Musico;

public class XMLMusicoToObject {

	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Musico.class);
			//Esta vez creamos un objeto que nos permite pasar
			//de XML a Object, es decir deserializar
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("kurt.xml");
			if (fichero.exists()) {
				Musico m = (Musico) u.unmarshal(fichero);
				System.out.println("El líder, vocalista y guitarra principal de Nirvana era: " + m.getNombre() + " " + m.getApellido());
				System.out.println(m);
			} else {
				System.out.println("Fichero XML kurt.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}

	}

}
