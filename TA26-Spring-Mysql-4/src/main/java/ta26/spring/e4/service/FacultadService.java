package ta26.spring.e4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e4.dao.FacultadDAO;
import ta26.spring.e4.dto.Facultad;

@Service
public class FacultadService {
	@Autowired
	FacultadDAO facultadDAO;

	public List<Facultad> listarFacultad() {
		return facultadDAO.findAll();
	}

	public Facultad guardarFacultad(Facultad venta) {
		return facultadDAO.save(venta);
	}

	public Facultad facultadXID(int id) {
		return facultadDAO.findById(id).get();
	}

	public Facultad actualizarFacultad(Facultad venta) {
		return facultadDAO.save(venta);
	}

	public void eliminarFacultad(int id) {
		facultadDAO.deleteById(id);
	}
}