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
import com.example.demo.dto.Investigador;
import com.example.demo.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {
	
	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigador(){
		return investigadorServiceImpl.listarInvestigadores();
	}
	
	@PostMapping("/investigadores")
	public Investigador salvarInvestigador(@RequestBody Investigador proveedor) {
		return investigadorServiceImpl.guardarInvestigador(proveedor);
	}
	
	@GetMapping("/investigadores/{dni}")
	public Investigador InvestigadorXDNI(@PathVariable(name="dni") String dni) {
		Investigador Investigador_x_dni = new Investigador();
		Investigador_x_dni = investigadorServiceImpl.investigadorXDNI(dni);
		
		System.out.println("Investigador X dni: " + Investigador_x_dni);
		return Investigador_x_dni;
	}
	
	@PutMapping("/investigadores/{dni}")
	public Investigador actualizarInvestigador(@PathVariable(name="dni")String dni,@RequestBody Investigador Investigador) {
		Investigador Investigador_seleccionado = new Investigador();
		Investigador Investigador_actualizado = new Investigador();
		
		Investigador_seleccionado = investigadorServiceImpl.investigadorXDNI(dni);
		
		Investigador_seleccionado.setNomApels(Investigador.getNomApels());
		Investigador_seleccionado.setFacultad(Investigador.getFacultad());
		
		Investigador_actualizado = investigadorServiceImpl.actualizarInvestigador(Investigador_seleccionado);
		
		System.out.println("El Investigador actualizado es: " + Investigador_actualizado);
		return Investigador_actualizado;
	}
	
	@DeleteMapping("/investigadores/{dni}")
	public void eleiminarInvestigador(@PathVariable(name="dni")String dni) {
		investigadorServiceImpl.eliminarInvestigador(dni);
	}
	
}
