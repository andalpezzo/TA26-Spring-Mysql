package ta26.spring.e2.controller;

import ta26.spring.e2.dto.Cientificos;
import ta26.spring.e2.service.CientificosService;

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
public class CientificosController {
	
	@Autowired
	CientificosService cientificosService;
	
	@GetMapping("/cientificos")
	public List<Cientificos> listarCientificos(){
		return cientificosService.listarCientificos();
	}
	
	
	@PostMapping("/cientificos")
	public Cientificos salvarCientificos(@RequestBody Cientificos pieza) {
		
		return cientificosService.guardarCientifico(pieza);
	}
	
	
	@GetMapping("/cientificos/{id}")
	public Cientificos cientificosXID(@PathVariable(name="id") int id) {
		
		Cientificos cientifico_xid= new Cientificos();
		
		cientifico_xid=cientificosService.cientificoXID(id);
		
		System.out.println("Cientifico XID: "+cientifico_xid);
		
		return cientifico_xid;
	}
	
	@PutMapping("/cientificos/{id}")
	public Cientificos actualizarCientificos(@PathVariable(name="id")int id,@RequestBody Cientificos cientificos) {
		
		Cientificos cientifico_seleccionado= new Cientificos();
		Cientificos cientifico_actualizado= new Cientificos();
		
		cientifico_seleccionado= cientificosService.cientificoXID(id);
		
		cientifico_seleccionado.setNomapels(cientificos.getNomapels());
		
		cientifico_actualizado = cientificosService.actualizarCientifico(cientifico_seleccionado);
		
		System.out.println("El Curso actualizado es: "+ cientifico_actualizado);
		
		return cientifico_actualizado;
	}
	
	@DeleteMapping("/cientificos/{id}")
	public void eliminarCientificos(@PathVariable(name="id")int id) {
		cientificosService.eliminarCientifico(id);
	}
}
