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
@Table(name = "ciudades")
public class Ciudades {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idciudad")
	private Long idCiudad;
	@Column(name = "nombreciudad")
	private String nombreCiudad;
	@Column(name = "proyecto")
	private Long proyecto;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ciu_nac")
    private Set<Personajes> personajes; 
	
	//----- GETTERS Y SETTERS -----// 
	//ID CIUDAD
	public Long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	//NOMBRE CIUDAD
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	
	//PROYECTO
	public Long getProyecto() {
		return proyecto;
	}
	public void setProyecto(Long proyecto) {
		this.proyecto = proyecto;
	}
		
	//Set de personajes
	protected Set<Personajes> getPersonajeCiudad() {
        if (this.personajes == null) {
            this.personajes= new HashSet<>();
        }
        return this.personajes;
    }

 
	protected void setPersonajeCiudad(Set<Personajes> personajes) {
        this.personajes = personajes;
    }
}
