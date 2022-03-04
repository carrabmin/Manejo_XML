package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="concierto")

// Establecemos el orden de los elementos
@XmlType(propOrder = {
		"nombre",
	    "ciudad",
	    "direccion",
	    "fecha",
	    "hora",
	    "participantes"
	})
public class Concierto {
	private String nombre;
	private String ciudad;
	private String direccion;
	private String fecha;
	private String hora;
	private List<Participante> participantes;

	public Concierto() {
		participantes = new ArrayList<Participante>();
	}
	
	//Establezco que cada elemento del array se serialice a una etiqueta xml cuyo nombre
	//sea "participante"
	@XmlElement(name = "participante")
	//Podemos crear una etiqueta que envuelva las etiquetas participante, si no la ponemos saldran
	//las etiquetas "participante" al mismo nivel que la de "concierto", de esta manera agrupamos todos
	//los "participantes" en la etiqueta "participantes"
	@XmlElementWrapper(name = "participantes")
	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
