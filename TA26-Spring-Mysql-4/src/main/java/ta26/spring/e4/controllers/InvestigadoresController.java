package ta26.spring.e4.controllers;

import ta26.spring.e4.dto.Investigadores;
import ta26.spring.e4.service.InvestigadoresService;

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
public class InvestigadoresController {

	@Autowired
	InvestigadoresService investigadoresService;

	@GetMapping("/investigadores")
	public List<Investigadores> listarInvestigadores() {
		return investigadoresService.listarInvestigadores();
	}

	@PostMapping("/investigadores")
	public Investigadores salvarInvestigadores(@RequestBody Investigadores investigadores) {

		return investigadoresService.guardarInvestigador(investigadores);
	}

	@GetMapping("/investigadores/{id}")
	public Investigadores investigadoresXID(@PathVariable(name = "dni") String dni) {

		return investigadoresService.investigadorXID(dni);
	}

	@PutMapping("/investigadores/{dni}")
	public Investigadores actualizarInvestigadores(@PathVariable(name = "dni") String dni,
			@RequestBody Investigadores investigadores) {

		Investigadores investigadores_seleccionado = new Investigadores();
		Investigadores investigadores_actualizado = new Investigadores();

		investigadores_seleccionado = investigadoresService.investigadorXID(dni);

		investigadores_seleccionado.setNomapels(investigadores.getNomapels());
		investigadores_seleccionado.setFacultad(investigadores.getFacultad());

		investigadores_actualizado = investigadoresService.actualizarInvestigador(investigadores_seleccionado);

		return investigadores_actualizado;
	}

	@DeleteMapping("/investigadores/{id}")
	public void eliminarInvestigadores(@PathVariable(name = "dni") String dni) {
		investigadoresService.eliminarInvestigador(dni);
	}

}
