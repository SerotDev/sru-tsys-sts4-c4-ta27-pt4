package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IEquipoDAO;
import com.example.demo.dto.Equipo;

@Service
public class EquipoServiceImpl implements IEquipoService {
	
	@Autowired
	IEquipoDAO iEquipoDAO;

	@Override
	public List<Equipo> listarEquipos() {
		return iEquipoDAO.findAll();
	}

	@Override
	public Equipo guardarEquipo(Equipo facultad) {
		return iEquipoDAO.save(facultad);
	}

	@Override
	public Equipo equipoXNUM(String numSerie) {
		return iEquipoDAO.findById(numSerie).get();
	}

	@Override
	public Equipo actualizarEquipo(Equipo facultad) {
		return iEquipoDAO.save(facultad);
	}

	@Override
	public void eliminarEquipo(String numSerie) {
		iEquipoDAO.deleteById(numSerie);
	}

}
