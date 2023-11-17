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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipos")//en caso que la tabala sea diferente
public class Equipo {
	//Atributos de entidad equipo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	@Column(name = "num_serie")
	private String num_serie;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
    @JoinColumn(name = "facultad")
    Facultad facultad;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Reserva> reserva;
	
	//Constructores
	public Equipo() {
	}

	/**
	 * @param num_serie
	 * @param nombre
	 * @param facultad
	 * @param reserva
	 */
	public Equipo(String num_serie, String nombre, Facultad facultad, List<Reserva> reserva) {
		this.num_serie = num_serie;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reserva = reserva;
	}


	//Getters y Setters
	/**
	 * @return return the numSerie
	 */
	public String getNum_serie() {
		return num_serie;
	}

	/**
	 * @param num_serie set the numSerie
	 */
	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	/**
	 * @return return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre set the nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return return the facultad
	 */
	public Facultad getFacultad() {
		return facultad;
	}

	/**
	 * @param facultad set the facultad
	 */
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	/**
	 * @return the reserva
	 */
	@JsonIgnore // Cierra recursividad
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva") // Mapea la entidad
	public List<Reserva> getReserva() {
		return reserva;
	}

	/**
	 * @param reserva set the reserva
	 */
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	
	//Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Equipo [num_serie=" + num_serie + ", nombre=" + nombre + ", facultad=" + facultad + "]";
	}
	
}