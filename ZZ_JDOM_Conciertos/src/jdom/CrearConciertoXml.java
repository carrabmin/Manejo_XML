package jdom;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

//A partir de informacion, creamos el xml:
public class CrearConciertoXml {
	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			// Creamos nuevo documento
			doc = analizador.newDocument();
			// Añadimos elemento raiz
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			// Añadimos tres participantes al elemento raíz concierto:
			agregarParticipantes(concierto, doc);
			// Guardamos en disco el nuevo documento XML:
			guardar(doc);
			
			System.out.println("El archivo se ha creado con éxito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void agregarParticipantes(Element concierto, Document doc) {
		// Agregamos el elemneto fecha:
		Element fecha = doc.createElement("fecha");
		concierto.appendChild(fecha);
		Text dia = doc.createTextNode("20-oct-2018");
		fecha.appendChild(dia);
		
		// Agregamos el elemento hora:
		Element hora = doc.createElement("hora");
		concierto.appendChild(hora);
		Text hora01 = doc.createTextNode("21:30");
		hora.appendChild(hora01);
		
		//Agregamos el elemento participantes:
		Element participantes = doc.createElement("participantes");
		concierto.appendChild(participantes);
		
		// Añadimos elementos participante:
		Element participante01 = doc.createElement("participante");
		participantes.appendChild(participante01);
		Element entrada01 = doc.createElement("entrada");
		entrada01.appendChild(doc.createTextNode("21:30"));
		participante01.appendChild(entrada01);
		Element grupo01 = doc.createElement("grupo");
		grupo01.appendChild(doc.createTextNode("Las Ardillas de Dakota"));
		participante01.appendChild(grupo01);
		
		Element participante02 = doc.createElement("participante");
		participantes.appendChild(participante02);
		Element entrada02 = doc.createElement("entrada");
		entrada02.appendChild(doc.createTextNode("22:15"));
		participante02.appendChild(entrada02);
		Element grupo02 = doc.createElement("grupo");
		grupo02.appendChild(doc.createTextNode("Fito y Fitipaldis"));
		participante02.appendChild(grupo02);
		
		Element participante03 = doc.createElement("participante");
		participantes.appendChild(participante03);
		Element entrada03 = doc.createElement("entrada");
		entrada03.appendChild(doc.createTextNode("23:00"));
		participante03.appendChild(entrada03);
		Element grupo03 = doc.createElement("grupo");
		grupo03.appendChild(doc.createTextNode("Coldplay"));
		participante03.appendChild(grupo03);
			
	}
	
	private static void guardar(Document doc) throws TransformerException {
		//Fabrica de Transformers:
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		//Creamos el objeto Transfomer, que nos permitira serializar el arbol
		//dom a un fichero:
		Transformer conversor = fabricaConversor.newTransformer();
		//Creamos la fuente de la cual sacaremos el arbol dom:
		DOMSource fuente = new DOMSource(doc); 
		//Creamos el flujo de salida, al fichero que queremos (tubito)
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		//Por ultimo, serializamos los datos:
		conversor.transform(fuente, resultado);
	}
}