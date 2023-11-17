package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Equipo;

public interface IEquipoService {

	// Metodos del CRUD
	public List<Equipo> listarEquipos(); // Listar All

	public Equipo guardarEquipo(Equipo equipo); // Guarda una Equipo (CREATE)

	public Equipo equipoXNUM(String numSerie); // Lee datos de una Equipo (READ)

	public Equipo actualizarEquipo(Equipo equipo); // Actualiza datos de la equipo (UPDATE)

	public void eliminarEquipo(String numSerie);// Elimina la equipo (DELETE)

}
