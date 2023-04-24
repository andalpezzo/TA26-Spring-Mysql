package ta26.spring.e3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e3.dao.MaquinasRegistradorasDAO;
import ta26.spring.e3.dto.MaquinasRegistradoras;

@Service
public class MaquinasRegistradorasService {
	@Autowired
	MaquinasRegistradorasDAO maquinasRegistradorasDAO;

	public List<MaquinasRegistradoras> listarMaquinasRegistradoras() {
		return maquinasRegistradorasDAO.findAll();
	}

	public MaquinasRegistradoras guardarMaquinaRegistradora(MaquinasRegistradoras maquina) {
		return maquinasRegistradorasDAO.save(maquina);
	}

	public MaquinasRegistradoras maquinaXID(int id) {
		return maquinasRegistradorasDAO.findById(id).get();
	}

	public MaquinasRegistradoras actualizarMaquinaRegistradora(MaquinasRegistradoras maquina) {
		return maquinasRegistradorasDAO.save(maquina);
	}

	public void eliminarMaquinaRegistradora(int id) {
		maquinasRegistradorasDAO.deleteById(id);

	}
}
