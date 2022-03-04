package main;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import beans.Musico;
import beans.Participante;

public class XMLParticipanteToObject {

	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Participante.class);
			//Esta vez creamos un objeto que nos permite pasar
			//de XML a Object, es decir deserializar
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("nirvana.xml");
			if (fichero.exists()) {
				
				Participante p = (Participante) u.unmarshal(fichero);
				System.out.println("El grupo " + p.getNombre() + " eran de nacionalidad " + p.getNacionalidad());
				System.out.println("Su mejor disco y éxito de ventas fue " + p.getDiscoExito());
				List<Musico> listaComponentes = p.getIntegrantes();
				System.out.println("Sus integrantes eran: ");
				for (Musico m: listaComponentes) {
					System.out.println("  " + m);
				}
				
			} else {
				System.out.println("Fichero XML nirvana.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}

	}

}
