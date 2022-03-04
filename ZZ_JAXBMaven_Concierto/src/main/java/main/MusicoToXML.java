package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Musico;

public class MusicoToXML {

	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			/*
			 * Obtiene el contexto asociado a la clase Musico, con dicho
			 * contexto podremos convertir el objeto a un xml y a la inversa. 
			 * Provoca una excepción de tipo JAXBException si la clase Musico 
			 * no cumple los requisitos para la conversión a XML, es decir, 
			 * contener las anotaciones necesarias y no cuenta con un constructor 
			 * sin argumentos:
			 */
			contexto = JAXBContext.newInstance(Musico.class);//inyeccion de dependecia
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}

		Marshaller m;
		try {
			/*
			 * Obtiene el objeto Marshaller asociado al contexto.
			 * Con dicho objeto podremos convertir un objeto en xml
			 * es decir, lo serializaremos:
			 */
			m = contexto.createMarshaller();
			/*
			 * Establecer la propiedad JAXB_FORMATTED_OUTPUT con el valor true 
			 * permite que en la conversión a formato XML se incluyan retornos 
			 * de carro e indentación (sangrado del texto). 
			 * Prueba a ejecutar el programa con los valores true y 
			 * false para ver la diferencia:
			 */
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//Creamos el musico con sus atributos:
			Musico musico = new Musico(1, "Kurt", "Cobain", 27, "Guitarra-Vocalista");
			
			//Convertimos un objeto a xml y lo imprimimos por pantalla
			m.marshal(musico, System.out);
			//Tambien podemos crear un fichero:
			m.marshal(musico, new File("kurt.xml"));
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}


