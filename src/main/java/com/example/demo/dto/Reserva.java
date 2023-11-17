package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reservas") // en caso que la tabala sea diferente
public class Reserva {
	// Atributos de entidad reserva
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;

	@ManyToOne
	@JoinColumn(name = "dni_investigador")
	Investigador investigador;

	@ManyToOne
	@JoinColumn(name = "num_serie_equipo")
	Equipo equipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date comienzo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fin;

	// Constructores
	public Reserva() {
	}

	/**
	 * @param id
	 * @param investigador
	 * @param equipo
	 * @param comienzo
	 * @param fin
	 */
	public Reserva(int id, Investigador investigador, Equipo equipo, Date comienzo, Date fin) {
		this.id = id;
		this.investigador = investigador;
		this.equipo = equipo;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	
	// Getters y Setters
	/**
	 * @return return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id set the id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return return the investigador
	 */
	public Investigador getInvestigador() {
		return investigador;
	}

	/**
	 * @param investigador set the investigador
	 */
	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	/**
	 * @return return the equipo
	 */
	public Equipo getEquipo() {
		return equipo;
	}

	/**
	 * @param equipo set the equipo
	 */
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	/**
	 * @return return the comienzo
	 */
	public Date getComienzo() {
		return comienzo;
	}

	/**
	 * @param comienzo set the comienzo
	 */
	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	/**
	 * @return return the fin
	 */
	public Date getFin() {
		return fin;
	}

	/**
	 * @param fin set the fin
	 */
	public void setFin(Date fin) {
		this.fin = fin;
	}

	
	// Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", investigador=" + investigador + ", equipo=" + equipo + ", comienzo=" + comienzo
				+ ", fin=" + fin + "]";
	}

}
