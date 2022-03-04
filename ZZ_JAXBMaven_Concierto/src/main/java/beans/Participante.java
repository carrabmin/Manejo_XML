package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Estas anotaciones sirven para que JAXB que es el motor de java para
//convertir objetos a XML y a la inversa, sepa como hacerlo
//serializar y deserializar

//esta etiqueta estamos estableciendo el nombre de el nodo raiz en xml
//etiqueta obligatoria
@XmlRootElement(name="participante")
//Podemos hacer que las etiquetas salgan en un determinado orden
//etiqueta opcional
@XmlType(propOrder = {
		"idGrupo",
	    "nombre",
	    "nacionalidad",
	    "integrantes",
	    "discoExito"
	})
public class Participante {
	private int idGrupo;
	private String nombre;
	private String nacionalidad;
	private List<Musico> integrantes;
	private String discoExito;
	
	//JAXB necesita para funcionar del constructor por defecto de java
	public Participante() {
		integrantes = new ArrayList<Musico>();
	}
	
	public Participante(int id, String nombre, String nacionalidad, String discoExito) {
		this.idGrupo = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.discoExito = discoExito;
	}

	//etiqueta que hace que el id de la persona se serialize como atributo de persona
	//etiqueta opcional
	@XmlAttribute(name = "id")
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	//etiqueta opcional
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="nacionalidad")
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@XmlElement(name="disco_exito")
	public String getDiscoExito() {
		return discoExito;
	}

	public void setDiscoExito(String discoExito) {
		this.discoExito = discoExito;
	}
	
	@XmlElement(name = "integrante")
	
	@XmlElementWrapper(name = "integrantes")
	public List<Musico> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Musico> integrantes) {
		this.integrantes = integrantes;
	}

	@Override
	public String toString() {
		return "Participante -> [idGrupo: " + idGrupo + ", Nombre: " + nombre + ", Nacionalidad: " + nacionalidad + ", Integrantes: " + integrantes
				+ ", Disco Éxito: " + discoExito + "]";
	}
	
	
}
