package jdom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


//En este ejemplo vamos a pasar un xml a un arbol DOM mediante Java:
 
public class LecturaXML {

	public static void main(String[] args) {
		//Lo primero necesitamos es una factoria que nos cree los objetos.
		//El patron factoría es un patron de diseño creacional, en la cual
		//su funcion es evitar el acoplamiento de clases, y de esta manera,
		//centralizar la creacion de los objetos en una única clase:
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		//Sigue el patron de diseño builder cuya funcion es crear objetos
		//complejos de manera simple:
		DocumentBuilder analizador;
		//El nodo documento
		Document doc;
		//Este nodo representara el nodo raiz en este ejemplo
		Node raiz;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			//Lo primero es deserializar el fichero cruceros.xml para
			//convertilo en un arbol DOM, basicamente lo que hacen los navegadores
			//El arbol DOM seran objetos con una jerarquia en forma de arbol
			doc = analizador.parse("concierto.xml");
			//Ponemos la referencia raiz en el objeto Document
			raiz = doc.getDocumentElement();
			recorrerNodos(raiz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void recorrerNodos(Node raiz) {
		//Este metodo nos devuelve todos los nodos hijos directos del elemento raiz "concierto"
		NodeList nodos = raiz.getChildNodes();
		//Accedemos a cada nodo hijo con su posición:
		Node nodoHijoFecha = nodos.item(0);
		Node nodoHijoHora = nodos.item(1);
		Node nodoHijoParticipantes = nodos.item(2);
		
		//Imprimimos el texto que contiene los nodos:
		System.out.println("Fecha y hora del concierto: " + nodoHijoFecha.getTextContent() + " " + nodoHijoHora.getTextContent());
				
		recorrerParticipantes(nodoHijoParticipantes);
		
	}
	
	
	private static void recorrerParticipantes(Node participantes) {
		//Este metodo nos devuelve todos los nodos hijos directos del elemento "participantes"
		NodeList nodos = participantes.getChildNodes();
		System.out.println("Participan los siguientes grupos:");
		// Iteración de los nodos participantes
		for (int i=0; i<nodos.getLength();i++) {
			Node participante = nodos.item(i);
			if (participante.getNodeType() == Node.ELEMENT_NODE) {
				//Dame los atriburos del nodo escala, y quiero el atributo 0 y 1, es decir
				//el primer y segundo atributo, a continuacion de pido el valor de ese nodo atributo
				Node entrada = participante.getChildNodes().item(0);
				Node grupo = participante.getChildNodes().item(1);
				System.out.println("  " + entrada.getTextContent() + " " + grupo.getTextContent());
			}
		}
	}

}
