package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import beans.Participante;
import beans.Musico;
import beans.Concierto;

public class ConciertoToXML {

	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Concierto.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();			
			return;//Dejamos de ejecutar el metodo main
		}

		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Concierto concierto = new Concierto();
			concierto.setNombre("Remember 2022");
			concierto.setCiudad("New York");
			concierto.setDireccion("Central Park");
			concierto.setFecha("16-Marzo-2022");
			concierto.setHora("21:30");
			
			Participante participante01 = new Participante();
			participante01.setIdGrupo(1);
			participante01.setNombre("Nirvana");
			participante01.setNacionalidad("Americana");
			participante01.setDiscoExito("Nevermind");
			
			participante01.getIntegrantes().add(new Musico(1, "Kurt", "Cobain", 27, "Guitarra-Vocalista"));
			participante01.getIntegrantes().add(new Musico(2, "Krist", "Novoselic", 56, "Bajo"));  
			participante01.getIntegrantes().add(new Musico(3, "Chad", "Channing", 55, "Bateria"));
			
			Participante participante02 = new Participante();
			participante02.setIdGrupo(2);
			participante02.setNombre("The Beatles");
			participante02.setNacionalidad("Inglesa");
			participante02.setDiscoExito("Sgt. Pepper's Lonely Hearts Club Band");
			
			participante02.getIntegrantes().add(new Musico(1, "John", "Lennon", 40, "Guitarra-Vocalista"));
			participante02.getIntegrantes().add(new Musico(2, "Paul", "McCartney", 79, "Bajo"));  
			participante02.getIntegrantes().add(new Musico(3, "George", "Harrison", 58, "Guitarra"));
			participante02.getIntegrantes().add(new Musico(4, "Ringo", "Starr", 81, "Bateria"));
			
			Participante participante03 = new Participante();
			participante03.setIdGrupo(3);
			participante03.setNombre("U2");
			participante03.setNacionalidad("Irlandesa");
			participante03.setDiscoExito("The Joshua Tree");
			
			participante03.getIntegrantes().add(new Musico(1, "Bono", "Hewson", 61, "Vocalista"));
			participante03.getIntegrantes().add(new Musico(2, "Edge", "Evans", 60, "Guitarra-Teclado"));  
			participante03.getIntegrantes().add(new Musico(3, "Adam Charles", "Clayton", 61, "Bajo"));
			participante03.getIntegrantes().add(new Musico(4, "Larry", "Mullen", 60, "Bateria"));
			
			concierto.getParticipantes().add(participante01);
			concierto.getParticipantes().add(participante02);
			concierto.getParticipantes().add(participante03);
			
			m.marshal(concierto, System.out);
			
			m.marshal(concierto, new File("concierto.xml"));
			System.out.println("El archivo concierto.xml ha sido creado con exito,"
					+ " refresque su eclipse :)");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}


	}

}
