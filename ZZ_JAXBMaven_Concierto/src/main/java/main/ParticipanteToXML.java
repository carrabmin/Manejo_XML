package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import beans.Participante;
import beans.Musico;

public class ParticipanteToXML {

	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Participante.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();			
			return;//Dejamos de ejecutar el metodo main
		}

		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Participante participantes = new Participante();
			participantes.setIdGrupo(1);
			participantes.setNombre("Nirvana");
			participantes.setNacionalidad("Americana");
			participantes.setDiscoExito("Nevermind");
			
			participantes.getIntegrantes().add(new Musico(1, "Kurt", "Cobain", 27, "Guitarra-Vocalista"));
			participantes.getIntegrantes().add(new Musico(2, "Krist", "Novoselic", 56, "Bajo"));  
			participantes.getIntegrantes().add(new Musico(3, "Chad", "Channing", 55, "Bateria"));
			
			m.marshal(participantes, System.out);
			
			m.marshal(participantes, new File("nirvana.xml"));
			System.out.println("El archivo nirvana.xml ha sido creado con exito,"
					+ " refresque su eclipse :)");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}

	}

}
