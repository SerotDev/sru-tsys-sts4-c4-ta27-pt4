package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Investigador;

public interface IInvestigadorService {

	// Metodos del CRUD
	public List<Investigador> listarInvestigadores(); // Listar All

	public Investigador guardarInvestigador(Investigador investigador); // Guarda una Investigador (CREATE)

	public Investigador investigadorXDNI(String dni); // Lee datos de una Investigador (READ)

	public Investigador actualizarInvestigador(Investigador investigador); // Actualiza datos de la investigador (UPDATE)

	public void eliminarInvestigador(String dni);// Elimina la investigador (DELETE)

}
