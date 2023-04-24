package ta26.spring.e1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e1.dao.ProveedoresDAO;
import ta26.spring.e1.dto.Proveedores;

@Service 
public class ProveedoresService {
	@Autowired
	ProveedoresDAO proveedoresDAO;

	public List<Proveedores> listarProveedores() {
		return proveedoresDAO.findAll();
	}

	public Proveedores guardarProveedor(Proveedores proveedor) {
		return proveedoresDAO.save(proveedor);
	}

	public Proveedores proveedorXID(int id) {
		return proveedoresDAO.findById(id).get();
	}

	public Proveedores actualizarProveedor(Proveedores proveedor) {
		return proveedoresDAO.save(proveedor);
	}

	public void eliminarProveedor(int id) {
		proveedoresDAO.deleteById(id);
	}
}
