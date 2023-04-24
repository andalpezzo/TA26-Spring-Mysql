package ta26.spring.e4.controllers;

import ta26.spring.e4.dto.Equipos;
import ta26.spring.e4.service.EquiposService;

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
public class EquiposController {

	@Autowired
	EquiposService equiposService;

	@GetMapping("/equipos")
	public List<Equipos> listarEquipos() {
		return equiposService.listarEquipos();
	}

	@PostMapping("/equipos")
	public Equipos salvarEquipos(@RequestBody Equipos Equipos) {

		return equiposService.guardarEquipos(Equipos);
	}

	@GetMapping("/equipos/{id}")
	public Equipos EquiposXID(@PathVariable(name = "id") int id) {

		return equiposService.equiposXID(id);
	}

	@PutMapping("/equipos/{id}")
	public Equipos actualizarEquipos(@PathVariable(name = "id") int id, @RequestBody Equipos equipos) {

		Equipos equipos_seleccionado = new Equipos();
		Equipos equipos_actualizado = new Equipos();

		equipos_seleccionado = equiposService.equiposXID(id);

		equipos_seleccionado.setNombre(equipos.getNombre());
		equipos_seleccionado.setFacultad(equipos.getFacultad());

		equipos_actualizado = equiposService.actualizarEquipo(equipos_seleccionado);

		return equipos_actualizado;
	}

	@DeleteMapping("/equipos/{id}")
	public void eliminarEquipos(@PathVariable(name = "id") int id) {
		equiposService.eliminarEquipo(id);
	}

}
