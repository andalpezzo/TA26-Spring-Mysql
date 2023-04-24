package ta26.spring.e3.controller;

import ta26.spring.e3.dto.Productos;
import ta26.spring.e3.service.ProductosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductosController {
	
	@Autowired
	ProductosService proyectoService;
	
	@GetMapping("/productos")
	public List<Productos> listarProductos(){
		return proyectoService.listarProductos();
	}
	
	
	@PostMapping("/productos")
	public Productos salvarProducto(@RequestBody Productos proyecto) {
		
		return proyectoService.guardarProducto(proyecto);
	}
	
	
	@GetMapping("/productos/{id}")
	public Productos proyectoXID(@PathVariable(name="id") int id) {
		
		return proyectoService.productoXID(id);
	}
	
	@PutMapping("/productos/{id}")
	public Productos actualizarProducto(@PathVariable(name="id") int id,@RequestBody Productos producto) {
		
		Productos producto_seleccionado= new Productos();
		Productos producto_actualizado= new Productos();
		
		producto_seleccionado= proyectoService.productoXID(id);
		
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_actualizado = proyectoService.actualizarProducto(producto_seleccionado);
		
		return producto_actualizado;
	}
	
	@DeleteMapping("/productos/{id}")
	public void eliminarProyecto(@PathVariable(name="id") int id) {
		proyectoService.eliminarProducto(id);
	}

}
