package ta26.spring.e3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e3.dao.VentaADAO;
import ta26.spring.e3.dto.Venta;

@Service
public class VentaService {
	@Autowired
	VentaADAO ventaDAO;

	public List<Venta> listarVenta() {
		return ventaDAO.findAll();
	}

	public Venta guardarVenta(Venta suministra) {
		return ventaDAO.save(suministra);
	}

	public Venta ventaXID(int id) {
		return ventaDAO.findById(id).get();
	}

	public Venta actualizarVenta(Venta suministra) {
		return ventaDAO.save(suministra);
	}

	public void eliminarVenta(int id) {
		ventaDAO.deleteById(id);
	}
}