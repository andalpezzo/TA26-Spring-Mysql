package ta26.spring.e4.controllers;

import ta26.spring.e4.dto.Reserva;
import ta26.spring.e4.service.ReservaService;

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
public class ReservaController {

	@Autowired
	ReservaService ReservaService;

	@GetMapping("/reserva")
	public List<Reserva> listarReserva() {
		return ReservaService.listarReservas();
	}

	@PostMapping("/reserva")
	public Reserva salvarReserva(@RequestBody Reserva reserva) {

		return ReservaService.guardarReserva(reserva);
	}

	@GetMapping("/reserva/{id}")
	public Reserva ReservaXID(@PathVariable(name = "id") int id) {

		return ReservaService.reservaXID(id);
	}

	@PutMapping("/reserva/{id}")
	public Reserva actualizarReserva(@PathVariable(name = "id") int id, @RequestBody Reserva reserva) {

		Reserva reserva_seleccionado = new Reserva();
		Reserva reserva_actualizado = new Reserva();

		reserva_seleccionado = ReservaService.reservaXID(id);

		reserva_seleccionado.setComienzo(reserva.getComienzo());
		reserva_seleccionado.setFin(reserva.getFin());
		reserva_seleccionado.setEquipo(reserva.getEquipo());
		reserva_seleccionado.setInvestigador(reserva.getInvestigador());

		reserva_actualizado = ReservaService.actualizarReserva(reserva_seleccionado);

		return reserva_actualizado;
	}

	@DeleteMapping("/reserva/{id}")
	public void eliminarReserva(@PathVariable(name = "id") int id) {
		ReservaService.eliminarReserva(id);
	}

}
