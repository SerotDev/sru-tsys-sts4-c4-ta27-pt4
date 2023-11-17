package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IReservaDAO;
import com.example.demo.dto.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService {
	
	@Autowired
	IReservaDAO iReservaDAO;

	@Override
	public List<Reserva> listarReserva() {
		return iReservaDAO.findAll();
	}

	@Override
	public Reserva guardarReserva(Reserva facultad) {
		return iReservaDAO.save(facultad);
	}

	@Override
	public Reserva reservaXID(int id) {
		return iReservaDAO.findById(id).get();
	}

	@Override
	public Reserva actualizarReserva(Reserva facultad) {
		return iReservaDAO.save(facultad);
	}

	@Override
	public void eliminarReserva(int id) {
		iReservaDAO.deleteById(id);
	}

}
