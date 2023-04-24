package ta26.spring.e2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e2.dao.ProyectosDAO;
import ta26.spring.e2.dto.Proyectos;

@Service
public class ProyectosService {
	@Autowired
	ProyectosDAO proyectosDAO;

	public List<Proyectos> listarProyectos() {
		return proyectosDAO.findAll();
	}

	public Proyectos guardarProyecto(Proyectos proyecto) {
		return proyectosDAO.save(proyecto);
	}

	public Proyectos proyectoXID(int id) {
		return proyectosDAO.findById(id).get();
	}

	public Proyectos actualizarProyecto(Proyectos proyecto) {
		return proyectosDAO.save(proyecto);
	}

	public void eliminarProyecto(int id) {
		proyectosDAO.deleteById(id);
	}
}
