package ta26.spring.e2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e2.dao.CientificosDAO;
import ta26.spring.e2.dto.Cientificos;

@Service
public class CientificosService {
	@Autowired
	CientificosDAO cientificosDAO;

	public List<Cientificos> listarCientificos() {
		return cientificosDAO.findAll();
	}

	public Cientificos guardarCientifico(Cientificos cientifico) {
		return cientificosDAO.save(cientifico);
	}

	public Cientificos cientificoXID(int id) {
		return cientificosDAO.findById(id).get();
	}

	public Cientificos actualizarCientifico(Cientificos cientifico) {
		return cientificosDAO.save(cientifico);
	}

	public void eliminarCientifico(int id) {
		cientificosDAO.deleteById(id);
	}
}
