package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Estas anotaciones sirven para que JAXB que es el motor de java para
//convertir objetos a XML y a la inversa, sepa como hacerlo
//serializar y deserializar

//Esta etiqueta estamos estableciendo el nombre de el nodo raiz en xml
//etiqueta obligatoria
@XmlRootElement(name="musico")
//Podemos hacer que las etiquetas salgan en un determinado orden
//etiqueta opcional
@XmlType(propOrder = {
		"idMusico",
	    "nombre",
	    "apellido",
	    "edad",
	    "instrumento"
	})

public class Musico {
	private int idMusico;
	private String nombre;
	private String apellido;
	private int edad;
	private String instrumento;
	
	//JAXB necesita para funcionar del constructor por defecto de java:
	public Musico() {
		
	}
	
	public Musico(int id, String nombre, String apellido, int edad, String instrumento) {
		this.idMusico = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.instrumento = instrumento;
	}

	//Etiqueta que hace que el id de la persona se serialize como atributo de persona
	//Etiqueta opcional:
	@XmlAttribute(name = "id")
	public int getIdMusico() {
		return idMusico;
	}
	public void setIdMusico(int idMusico) {
		this.idMusico = idMusico;
	}

	//Etiqueta opcional:
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="apellidos")
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@XmlElement
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@XmlElement
	public String getInstrumento() {
		return instrumento;
	}
	
	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	@Override
	public String toString() {
		return "Músico -> [idMusico: " + idMusico + ", Nombre: " + nombre + ", Apellidos: " + apellido + ", Edad: " + edad
				+ ", Instrumento: " + instrumento + "]";
	}
	
	
}


