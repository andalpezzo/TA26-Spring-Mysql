package ta26.spring.e3.controller;

import ta26.spring.e3.dto.Venta;
import ta26.spring.e3.service.VentaService;

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
public class VentasController {
	
	@Autowired
	VentaService ventaService;
	
	@GetMapping("/ventas")
	public List<Venta> listarAsignadoA(){
		return ventaService.listarVenta();
	}
	
	
	@PostMapping("/ventas")
	public Venta salvarAsignadoA(@RequestBody Venta venta) {
		
		return ventaService.guardarVenta(venta);
	}
	
	
	@GetMapping("/ventas/{id}")
	public Venta asignadoAXID(@PathVariable(name="id") int id) {

		return ventaService.ventaXID(id);
	}
	
	@PutMapping("/ventas/{id}")
	public Venta actualizarAsignadoA(@PathVariable(name="id") int id,@RequestBody Venta venta) {
		
		Venta asignado_a_seleccionado= new Venta();
		Venta asignado_a_actualizado= new Venta();
		
		asignado_a_seleccionado= ventaService.ventaXID(id);
		
		
		asignado_a_seleccionado.setCajero(venta.getCajero());
		asignado_a_seleccionado.setProducto(venta.getProducto());
		asignado_a_seleccionado.setMaquina(venta.getMaquina());
		
		asignado_a_actualizado = ventaService.actualizarVenta(asignado_a_seleccionado);
		
		return asignado_a_actualizado;
	}
	
	@DeleteMapping("/ventas/{id}")
	public void eliminarAsignadoA(@PathVariable(name="id") int id) {
		ventaService.eliminarVenta(id);
	}

}