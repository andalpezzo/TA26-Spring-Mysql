package ta26.spring.e3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e3.dao.ProductosDAO;
import ta26.spring.e3.dto.Productos;

@Service
public class ProductosService {
	@Autowired
	ProductosDAO productosDAO;

	public List<Productos> listarProductos() {
		return productosDAO.findAll();
	}

	public Productos guardarProducto(Productos producto) {
		return productosDAO.save(producto);
	}

	public Productos productoXID(int id) {
		return productosDAO.findById(id).get();
	}

	public Productos actualizarProducto(Productos proyecto) {
		return productosDAO.save(proyecto);
	}

	public void eliminarProducto(int id) {
		productosDAO.deleteById(id);
	}
}
