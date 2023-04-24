package ta26.spring.e3.controller;

import ta26.spring.e3.dto.MaquinasRegistradoras;
import ta26.spring.e3.service.MaquinasRegistradorasService;

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
public class MaquinasRegistradorasController {
	
	@Autowired
	MaquinasRegistradorasService maquinasRegistradorasService;
	
	@GetMapping("/maquinas")
	public List<MaquinasRegistradoras> listarCajeros(){
		return maquinasRegistradorasService.listarMaquinasRegistradoras();
	}
	
	
	@PostMapping("/maquinas")
	public MaquinasRegistradoras salvarCajeros(@RequestBody MaquinasRegistradoras maquina) {
		
		return maquinasRegistradorasService.guardarMaquinaRegistradora(maquina);
	}
	
	
	@GetMapping("/maquinas/{id}")
	public MaquinasRegistradoras cientificosXID(@PathVariable(name="id") int id) {
		
		return maquinasRegistradorasService.maquinaXID(id);
	}
	
	@PutMapping("/maquinas/{id}")
	public MaquinasRegistradoras actualizarCajeros(@PathVariable(name="id") int id,@RequestBody MaquinasRegistradoras maquina) {
		
		MaquinasRegistradoras maquina_seleccionada= new MaquinasRegistradoras();
		MaquinasRegistradoras maquina_actualizada= new MaquinasRegistradoras();
		
		maquina_seleccionada= maquinasRegistradorasService.maquinaXID(id);
		
		maquina_seleccionada.setPiso(maquina.getPiso());
		
		maquina_actualizada = maquinasRegistradorasService.actualizarMaquinaRegistradora(maquina_seleccionada);
		
		return maquina_actualizada;
	}
	
	@DeleteMapping("/maquinas/{id}")
	public void eliminarCajeros(@PathVariable(name="id") int id) {
		maquinasRegistradorasService.eliminarMaquinaRegistradora(id);
	}
	
	
}
