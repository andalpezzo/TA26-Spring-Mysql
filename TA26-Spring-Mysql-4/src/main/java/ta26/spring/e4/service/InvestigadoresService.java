package ta26.spring.e4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e4.dao.InvestigadoresDAO;
import ta26.spring.e4.dto.Investigadores;

@Service
public class InvestigadoresService {
	@Autowired
	InvestigadoresDAO investigadoresDAO;

	public List<Investigadores> listarInvestigadores() {
		return investigadoresDAO.findAll();
	}

	public Investigadores guardarInvestigador(Investigadores investigador) {
		return investigadoresDAO.save(investigador);
	}
	
	public Investigadores investigadorXID(String dni) {
		return investigadoresDAO.findById(dni).get();
	}

	public Investigadores actualizarInvestigador(Investigadores investigador) {
		return investigadoresDAO.save(investigador);
	}

	public void eliminarInvestigador(String dni) {
		investigadoresDAO.deleteById(dni);
	}
}