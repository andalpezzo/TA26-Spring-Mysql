package ta26.spring.e2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e2.dao.AsignadoADAO;
import ta26.spring.e2.dto.AsignadoA;

@Service
public class AsignaAService {
	@Autowired
	AsignadoADAO asignadoADAO;

	public List<AsignadoA> listarAsignadoA() {
		return asignadoADAO.findAll();
	}
	
	public AsignadoA guardarAsignadoA(AsignadoA suministra) {
		return asignadoADAO.save(suministra);
	}
	
	public AsignadoA asignadoAXID(int id) {
		return asignadoADAO.findById(id).get();
	}
	
	public AsignadoA actualizarAsignadoA(AsignadoA suministra) {
		return asignadoADAO.save(suministra);
	}

	public void eliminarAsignadoA(int id) {
		asignadoADAO.deleteById(id);
	}
}