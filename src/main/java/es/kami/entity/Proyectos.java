package es.kami.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyectos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idproyecto")
	private Long idProyecto;
	@Column(name = "nombre")
	private String nombreProyecto;
	@Column(name = "codigoproyecto")
	private String codigoProyecto;
	@Column(name = "sinopsis")
	private String sinopsis;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
	private Set<Personajes> personajes; 
	
	//----- GETTERS Y SETTERS -----// 
	//ID CIUDAD
	public Long getIdProyecto() {
		return idProyecto;
	}
	public void setIdTipo(Long idProyecto) {
		this.idProyecto = idProyecto;
	}
	
	//NOMBRE CIUDAD
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	
	//NOMBRE CIUDAD
	public String getCodigoProyecto() {
		return codigoProyecto;
	}
	public void setCodigoProyecto(String codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}
		
	//SINOPSIS	
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	
	//Set de personajes
	protected Set<Personajes> getPersonajeProyecto() {
	       if (this.personajes == null) {
	           this.personajes= new HashSet<>();
	       }
	       return this.personajes;
	   }
	
    protected void getPersonajeProyecto(Set<Personajes> personajes) {
        this.personajes = personajes;
    }
}