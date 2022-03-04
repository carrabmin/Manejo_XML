package main;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import beans.Musico;
import beans.Participante;
import beans.Concierto;

public class XMLConciertoToObject {

	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Concierto.class);
			//Esta vez creamos un objeto que nos permite pasar
			//de XML a Object, es decir deserializar
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("concierto.xml");
			if (fichero.exists()) {
				
				Concierto c = (Concierto) u.unmarshal(fichero);
				System.out.println("El concierto " + c.getNombre() + " se celebra el día " + c.getFecha() + 
										" a las " + c.getHora() + " en la ciudad de " + c.getCiudad());
				
				List<Participante> listaParticipantes = c.getParticipantes();
				System.out.println("\nParticipan los grupos: ");
				for (Participante p: listaParticipantes) {
					System.out.println("  " + p.getNombre() + " (Nacionalidad " + p.getNacionalidad() +
										" / Disco Éxito: " + p.getDiscoExito() + ")");
					List<Musico> listaMusicos = p.getIntegrantes();
						System.out.println("    Su líder es: " + listaMusicos.get(0).getNombre() + " " + listaMusicos.get(0).getApellido() +
											" (Instrumento: " + listaMusicos.get(0).getInstrumento() + ")\n");
				}
				
			} else {
				System.out.println("Fichero XML concierto.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}

	}

}
