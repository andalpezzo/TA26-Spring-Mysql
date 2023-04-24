package ta26.spring.e4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ta26.spring.e4.dto.Reserva;

public interface ReservaDAO extends JpaRepository<Reserva, Integer> {

}