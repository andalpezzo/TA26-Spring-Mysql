package ta26.spring.e3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e3.dao.CajerosDAO;
import ta26.spring.e3.dto.Cajeros;

@Service
public class CajerosService {
	@Autowired
	CajerosDAO cajerosDAO;

	public List<Cajeros> listarCajeros() {
		return cajerosDAO.findAll();
	}

	public Cajeros guardarCajero(Cajeros cientifico) {
		return cajerosDAO.save(cientifico);
	}

	public Cajeros cajeroXID(int id) {
		return cajerosDAO.findById(id).get();
	}

	public Cajeros actualizarCajero(Cajeros cientifico) {
		return cajerosDAO.save(cientifico);
	}

	public void eliminarCajero(int id) {
		cajerosDAO.deleteById(id);
	}
}
