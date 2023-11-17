package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Facultad;

public interface IFacultadService {

	// Metodos del CRUD
	public List<Facultad> listarFacultades(); // Listar All

	public Facultad guardarFacultad(Facultad facultad); // Guarda un Facultad (CREATE)

	public Facultad facultadXCODIGO(int codigo); // Lee datos de un Facultad (READ)

	public Facultad actualizarFacultad(Facultad facultad); // Actualiza datos del Facultad (UPDATE)

	public void eliminarFacultad(int codigo);// Elimina el Facultad (DELETE)

}
