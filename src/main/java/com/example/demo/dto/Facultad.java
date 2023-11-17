package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "facultades") // en caso que la tabala sea diferente
public class Facultad {
	// Atributos de entidad facultad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private int codigo;

	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "dni")
	private List<Investigador> investigador;
	
	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Equipo> equipo;

	// Constructores
	public Facultad() {
	}

	/**
	 * @param codigo
	 * @param nombre
	 * @param investigador
	 * @param equipo
	 */
	public Facultad(int codigo, String nombre, List<Investigador> investigador, List<Equipo> equipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.investigador = investigador;
		this.equipo = equipo;
	}


	// Getters y Setters
	/**
	 * @return returns the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo sets the codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return returns the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre sets the nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the investigador
	 */
	@JsonIgnore // Cierra recursividad
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigador") // Mapea la entidad Investigador
	public List<Investigador> getInvestigador() {
		return investigador;
	}

	/**
	 * @param investigador the investigador to set
	 */
	public void setInvestigador(List<Investigador> investigador) {
		this.investigador = investigador;
	}
	
	/**
	 * @return return the equipo
	 */
	@JsonIgnore // Cierra recursividad
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipo") // Mapea la entidad Equipo
	public List<Equipo> getEquipo() {
		return equipo;
	}

	/**
	 * @param equipo set the equipo
	 */
	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	// Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Facultad [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
