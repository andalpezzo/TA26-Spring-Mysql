package ta26.spring.e3.controller;

import ta26.spring.e3.dto.Cajeros;
import ta26.spring.e3.service.CajerosService;

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
public class CajerosController {
	
	@Autowired
	CajerosService cajerosService;
	
	@GetMapping("/cajeros")
	public List<Cajeros> listarCajeros(){
		return cajerosService.listarCajeros();
	}
	
	@PostMapping("/cajeros")
	public Cajeros salvarCajeros(@RequestBody Cajeros cajero) {
		
		return cajerosService.guardarCajero(cajero);
	}
	
	
	@GetMapping("/cajeros/{id}")
	public Cajeros cientificosXID(@PathVariable(name="id") int id) {
		
		return cajerosService.cajeroXID(id);
	}
	
	@PutMapping("/cajeros/{id}")
	public Cajeros actualizarCajeros(@PathVariable(name="id") int id,@RequestBody Cajeros cajero) {
		
		Cajeros cajero_seleccionado= new Cajeros();
		Cajeros cajero_actualizado= new Cajeros();
		
		cajero_seleccionado= cajerosService.cajeroXID(id);
		
		cajero_seleccionado.setNomapels(cajero.getNomapels());
		
		cajero_actualizado = cajerosService.actualizarCajero(cajero_seleccionado);
		
		return cajero_actualizado;
	}
	
	@DeleteMapping("/cajeros/{id}")
	public void eliminarCajeros(@PathVariable(name="id") int id) {
		cajerosService.eliminarCajero(id);
	}
}
