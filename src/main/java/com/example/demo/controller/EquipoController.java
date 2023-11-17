package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Equipo;
import com.example.demo.service.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquipoController {
	
	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipo> listarEquipos(){
		return equipoServiceImpl.listarEquipos();
	}
	
	@PostMapping("/equipos")
	public Equipo salvarEquipo(@RequestBody Equipo facultad) {
		return equipoServiceImpl.guardarEquipo(facultad);
	}
	
	@GetMapping("/equipos/{numSerie}")
	public Equipo EquipoXNUM(@PathVariable(name="numSerie") String numSerie) {
		Equipo Equipo_x_num = new Equipo();
		Equipo_x_num = equipoServiceImpl.equipoXNUM(numSerie);
		
		System.out.println("Equipo X NumSerie: " + Equipo_x_num);
		return Equipo_x_num;
	}
	
	@PutMapping("/equipos/{numSerie}")
	public Equipo actualizarEquipo(@PathVariable(name="numSerie")String numSerie,@RequestBody Equipo Equipo) {
		Equipo Equipo_seleccionado = new Equipo();
		Equipo Equipo_actualizado = new Equipo();
		
		Equipo_seleccionado = equipoServiceImpl.equipoXNUM(numSerie);
		
		Equipo_seleccionado.setNombre(Equipo.getNombre());
		Equipo_seleccionado.setFacultad(Equipo.getFacultad());
		
		Equipo_actualizado = equipoServiceImpl.actualizarEquipo(Equipo_seleccionado);
		
		System.out.println("La Equipo actualizado es: " + Equipo_actualizado);
		return Equipo_actualizado;
	}
	
	@DeleteMapping("/equipos/{numSerie}")
	public void eleiminarEquipo(@PathVariable(name="numSerie")String numSerie) {
		equipoServiceImpl.eliminarEquipo(numSerie);
	}
	
}
