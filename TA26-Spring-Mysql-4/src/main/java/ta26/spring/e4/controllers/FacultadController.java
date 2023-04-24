package ta26.spring.e4.controllers;

import ta26.spring.e4.dto.Facultad;
import ta26.spring.e4.service.FacultadService;

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
public class FacultadController {

	@Autowired
	FacultadService facultadService;

	@GetMapping("/facultad")
	public List<Facultad> listarFacultad() {
		return facultadService.listarFacultad();
	}

	@PostMapping("/facultad")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {

		return facultadService.guardarFacultad(facultad);
	}

	@GetMapping("/facultad/{id}")
	public Facultad facultadXID(@PathVariable(name = "id") int id) {

		return facultadService.facultadXID(id);
	}

	@PutMapping("/facultad/{id}")
	public Facultad actualizarFacultad(@PathVariable(name = "id") int id, @RequestBody Facultad facultad) {

		Facultad facultad_seleccionado = new Facultad();
		Facultad facultad_actualizado = new Facultad();

		facultad_seleccionado = facultadService.facultadXID(id);

		facultad_seleccionado.setNombre(facultad.getNombre());

		facultad_actualizado = facultadService.actualizarFacultad(facultad_seleccionado);

		return facultad_actualizado;
	}

	@DeleteMapping("/facultad/{id}")
	public void eliminarFacultad(@PathVariable(name = "id") int id) {
		facultadService.eliminarFacultad(id);
	}

}
