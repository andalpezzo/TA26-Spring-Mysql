package ta26.spring.e4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ta26.spring.e4.dao.ReservaDAO;
import ta26.spring.e4.dto.Reserva;

@Service
public class ReservaService {
	@Autowired
	ReservaDAO reservaDAO;

	public List<Reserva> listarReservas() {
		return reservaDAO.findAll();
	}

	public Reserva guardarReserva(Reserva reserva) {
		return reservaDAO.save(reserva);
	}

	public Reserva reservaXID(int id) {
		return reservaDAO.findById(id).get();
	}

	public Reserva actualizarReserva(Reserva reserva) {
		return reservaDAO.save(reserva);
	}

	public void eliminarReserva(int id) {
		reservaDAO.deleteById(id);
	}
}