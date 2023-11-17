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
import com.example.demo.dto.Facultad;
import com.example.demo.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {
	
	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	
	@GetMapping("/facultades")
	public List<Facultad> listarCfacultades(){
		return facultadServiceImpl.listarFacultades();
	}
	
	@PostMapping("/facultades")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {
		return facultadServiceImpl.guardarFacultad(facultad);
	}
	
	@GetMapping("/facultades/{codigo}")
	public Facultad facultadXCODIGO(@PathVariable(name="codigo") int codigo) {
		Facultad Facultad_x_codigo = new Facultad();
		Facultad_x_codigo = facultadServiceImpl.facultadXCODIGO(codigo);
		
		System.out.println("Facultad X codigo: " + Facultad_x_codigo);
		return Facultad_x_codigo;
	}
	
	@PutMapping("/facultades/{codigo}")
	public Facultad actualizarFacultad(@PathVariable(name="codigo")int codigo,@RequestBody Facultad facultad) {
		Facultad Facultad_seleccionado = new Facultad();
		Facultad Facultad_actualizado = new Facultad();
		
		Facultad_seleccionado = facultadServiceImpl.facultadXCODIGO(codigo);
		
		Facultad_seleccionado.setNombre(facultad.getNombre());
		
		Facultad_actualizado = facultadServiceImpl.actualizarFacultad(Facultad_seleccionado);
		
		System.out.println("El Facultad actualizado es: " + Facultad_actualizado);
		return Facultad_actualizado;
	}
	
	@DeleteMapping("/facultades/{codigo}")
	public void eleiminarFacultad(@PathVariable(name="codigo")int codigo) {
		facultadServiceImpl.eliminarFacultad(codigo);
	}
	
}
