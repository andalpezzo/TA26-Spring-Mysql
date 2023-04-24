package ta26.spring.e4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e4.dao.EquiposDAO;
import ta26.spring.e4.dto.Equipos;

@Service
public class EquiposService {
	@Autowired
	EquiposDAO equiposDAO;
	
	public List<Equipos> listarEquipos() {
		return equiposDAO.findAll();
	}

	public Equipos guardarEquipos(Equipos equipo) {
		return equiposDAO.save(equipo);
	}

	public Equipos equiposXID(int id) {
		return equiposDAO.findById(id).get();
	}

	public Equipos actualizarEquipo(Equipos equipo) {
		return equiposDAO.save(equipo);
	}

	public void eliminarEquipo(int id) {
		equiposDAO.deleteById(id);

	}
}