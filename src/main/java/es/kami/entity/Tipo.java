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
@Table(name = "tipopersonaje")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtipo")
	private Long idTipo;
	@Column(name = "nombretipo")
	private String nombreTipo;
	 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private Set<Personajes> personajes; 
	
	//----- GETTERS Y SETTERS -----// 
	//ID CIUDAD
	public Long getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}
	//NOMBRE CIUDAD
	public String getNombreTipo() {
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	//Set de personajes
	protected Set<Personajes> getPersonajeTipo() {
        if (this.personajes == null) {
            this.personajes= new HashSet<>();
        }
        return this.personajes;
    }

    protected void setPersonajeTipo(Set<Personajes> personajes) {
        this.personajes = personajes;
    }
}
