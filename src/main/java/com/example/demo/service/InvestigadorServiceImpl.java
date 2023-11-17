package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IInvestigadorDAO;
import com.example.demo.dto.Investigador;

@Service
public class InvestigadorServiceImpl implements IInvestigadorService {
	
	@Autowired
	IInvestigadorDAO iInvestigadorDAO;

	@Override
	public List<Investigador> listarInvestigadores() {
		return iInvestigadorDAO.findAll();
	}

	@Override
	public Investigador guardarInvestigador(Investigador proveedor) {
		return iInvestigadorDAO.save(proveedor);
	}

	@Override
	public Investigador investigadorXDNI(String dni) {
		return iInvestigadorDAO.findById(dni).get();
	}

	@Override
	public Investigador actualizarInvestigador(Investigador proveedor) {
		return iInvestigadorDAO.save(proveedor);
	}

	@Override
	public void eliminarInvestigador(String dni) {
		iInvestigadorDAO.deleteById(dni);
	}

}
