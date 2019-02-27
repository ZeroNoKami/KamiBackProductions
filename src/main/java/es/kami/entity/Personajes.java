package es.kami.entity;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "personajes")
public class Personajes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_personaje")
	private Long idPersonaje;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "deidad")
	private String deidad;
	@ManyToOne
	@JoinColumn
	(name = "tipo", foreignKey = @ForeignKey(name="personajes_ibfk_1"))
	private Tipo tipo;
	@Column(name = "arma")
	private String arma;
	@ManyToOne
	@JoinColumn
	(name = "ciu_nac", foreignKey = @ForeignKey(name="personajes_ibfk_2"))
	private Ciudades ciu_nac;
	@ManyToOne
	@JoinColumn
	(name = "proyecto", foreignKey = @ForeignKey(name="personajes_ibfk_3"))
	private Proyectos proyecto;
	
	//----- GETTERS Y SETTERS -----// 
	//ID PERSONAJE
	public Long getIdPersonaje() {
		return idPersonaje;
	}
	public void setIdPersonaje(Long idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	//NOMBRE PERSONAJE
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//DEIDAD PERSONAJE
	public String getDeidad() {
		return deidad;
	}
	public void setDeidad(String deidad) {
		this.deidad = deidad;
	}
	//TIPO PERSONAJE
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	//ARMA PERSONAJE
	public String getArma() {
		return arma;
	}
	public void setArma(String arma) {
		this.arma = arma;
	}
	//CIUDAD PERSONAJE
	public Ciudades getCiu_nac() {
		return ciu_nac;
	}
	public void setCiu_nac(Ciudades ciu_nac) {
		this.ciu_nac = ciu_nac;
	}
	
	//PROYECTO PERSONAJE
	public Proyectos getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyectos proyecto) {
		this.proyecto = proyecto;
	}
}
